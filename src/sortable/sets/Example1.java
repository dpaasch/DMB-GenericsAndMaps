package sortable.sets;

import java.util.*;
import common.*;

/**
 * This class demonstrates an implementations of the
 * Set interface that does sorting AND duplicate removal -- TreeSet. Note that
 * To be sortable, objects stored in these
 * data structures must implement the Comparable interface.
 *
 * NOTE: we are using Generics here. If you do not, you will
 * need to cast what comes out.
 *
 * @author jlombardo
 * @see Employee
 */
public class Example1 {
    public static void main(String[] args) {
        // Let's begin by creating some Employee objects
        Employee e1 = new Employee(3,"Doe", "John", "333-33-3333");
        Employee e2 = new Employee(2,"Smith", "Sally", "111-11-1111");
        Employee e3 = new Employee(4,"Evans", "Bob", "444-44-4444");
        Employee e4 = new Employee(2,"Mallay", "Fred", "222-22-2222");
        
        // Store them in a TreeSet, which removes dupes and sorts!
        // Note that the TreeSet will base duplicates on ssn values
        // Note that the sort, equals and hashCode methods must be consistent,
        // i.e., based on the same criteria!
        Set<Employee> set = new TreeSet<Employee>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);


        // Get the size of the Set (which should now be 3, to prove that
        // the duplicate was removed AND the set is sorted!
        // ... then we can loop and output...
        System.out.println("The size of the Sorted Set is: " + set.size());
        for(Employee e : set) {
            System.out.println(e);
        }

        // After running this the first time, goto the Employee class and
        // comment out the compareTo method. Then remove the interface
        // implementation in the class definition. Then run this test again.
        // Notice that the program crashes with an exception. Why? Because
        // Tree structures absolutely require that you implement the
        // Comparable interface in the classes of objects you want to sort.
    }
}
