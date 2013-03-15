package utility.sort;

import java.util.*;
import common.*;

/**
 * This class demonstrates an implementations of the
 * List interface which cannot do sorting. However, there is a utility class --
 * Collections -- that has sort methods to help. This is a demonstration of
 * how to use that class. To be sortable, objects stored in these
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
        Employee e4 = new Employee(1,"Mallay", "Fred", "222-22-2222");
        // store them in a List, which does not sort
        List<Employee> list = new ArrayList<Employee>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        // OK, now let's sort the list with the help of the Collections class:
        // Comment this line out and no sorting will be performed.
        Collections.sort(list);

        // Get the size of the Set (which should now be 3, to prove that
        // the duplicate was removed AND the set is sorted!
        // ... then we can loop and output...
        System.out.println("The size of the List is: " + list.size());
        for(Employee e : list) {
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
