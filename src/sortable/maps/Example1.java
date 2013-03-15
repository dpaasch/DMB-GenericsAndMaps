package sortable.maps;

import common.Employee;
import common.EmployeeByLastName;
import java.util.*;

/**
 * This class demonstrates an implementations of the
 * Map interface that does sorting -- TreeMap. Note that there is also
 * a TreeSet that performs sorts. To be sortable, objects stored in these
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
        
        // store them in a TreeMap -- a map structure that sorts by
        // the natural order of the key objects, as defined by the Comparable interface
        Map<String, Employee> map =
                new HashMap<String, Employee>();
        map.put("333-33-3333", e1);
        map.put("111-11-1111", e2);
        map.put("444-44-4444", e3);
        map.put("222-22-2222", e4);
        // now retrieve one by its key
        Employee e = map.get("111-11-1111");
        System.out.println("Found emloyee with key 111-11-1111: " + e);

        // Now let's loop thru the map and retrieve each employee by its key.
        // Notice there is no sorting and the objects retrieve are not
        // guaranteed to come out in the order they were entered...
        System.out.println("\nUsing a keyset, get the employees by key, unsorted, unordered...");
        Set<String> keys = map.keySet();
        for(String key : keys) {
            Employee found = map.get(key);
            System.out.println(found.toString());
        }

        // That's all there is to basic storage and retrieval.
        // But what if you want to loop through a Map? Well,
        // Maps are not sequential lists of objects. They are
        // randomly stored key-value pairs. Therefore, you can't
        // loop through the pairs, but you CAN loop through all
        // they keys or all the values:

        // Let's loop through the keys, retrieving each object
        // stored in the map and print out it's toString value.
        // Keys must be unique so we should use a set. Note
        // that the isertion order is NOT maintained:
        System.out.println("\nUsing a keyset, get the employees sorted by key (ssn)...");
        Map<String,Employee> map2 = new TreeMap<String,Employee>(map);
        Set<String> keys2 = map2.keySet();
        for(String key : keys2) {
            Employee found = map.get(key);
            System.out.println(found.toString());
        }

        // That wasn't too hard. But what if you want
        // only a collection of the values? It's not as
        // common, but easy to do. Remember, values are
        // not necessarily unique, so we don't need a Set.
        // Note that the insertion order is NOT maintained:
        System.out.println("\nUsing a collection of values, get the Employees"
                + " sorted by natural order (empID) as defined by "
                + "the Comparable interface ...");
        Collection<Employee> values = map2.values();
        // Now put in List because Collections.sort reuquires it...
        List<Employee> sortedList = new ArrayList<Employee>(values);
        // Now use the utility class to perform the sort using the
        // natural order (Comparable) of the entity object
        Collections.sort(sortedList);
        for(Employee emp : sortedList) {
            System.out.println(emp);
        }
 
        // Now let's sort the Employeess in an alternate way -- by lastName,
        // using a Comparator
        System.out.println("\nUsing a collection of values, get the Employees"
                + " sorted by a Comparator (lastName) as an alternative"
                + " to the natural order...");
        Collection<Employee> values2 = map2.values();
        // Now put in List
        List<Employee> sortedList2 = new ArrayList<Employee>(values2);
        // Notice this version of Collections.sort takes a 2nd paramater --
        // a Comparator that defines the altnerate sort strategy
        Collections.sort(sortedList2, new EmployeeByLastName());
        for(Employee emp : sortedList2) {
            System.out.println(emp);
        }
       
        // Now that you've run this code, change the Map above
        // to a HashMap, or a LinkedHashMap. Then re-run. No change, right? 
        // That's because Hashtable and HashMap are based on the Map
        // interface, and thus, both behave the same way. But
        // HashMap is faster because it is NOT thread safe.
    }
}
