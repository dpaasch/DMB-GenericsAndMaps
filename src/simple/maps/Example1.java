package simple.maps;

import common.Employee;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class demonstrates simple implementations of the
 * Map interface -- Hashtable, HashMap and LinkedHashMap.
 * They are designated as "simple" because they don't
 * provide any additional functionality other than efficient
 * storage and retrieval. The great benefit of a Map over a
 * List or a Set is that you can retrieve a value by a
 * unique key. And keys are easier to remember than the
 * index value of a List, agreed?
 *
 * NOTE: we are NOT using Generics here. Remember you have to cast what 
 * comes out, unless you are using the toString() implicit reference.
 *
 * @author jlombardo
 */
public class Example1 {
    public static void main(String[] args) {
        // Let's begin by using the oldest type of Map,
        // a Hashtable. This map is thread safe, one of the
        // few collection classes that are. As a result
        // it's slower than a HashMap. Maps store key=value
        // pairs, where the key is the lookup object and
        // the value is the object you get when ask for the key.
        // Often, but not always, keys are more convenient as String 
        // or Integer values.
        Employee e1 = new Employee(1,"Doe", "John", "333-33-3333");
        Employee e2 = new Employee(2,"Smith", "Sally", "111-11-1111");
        Employee e3 = new Employee(3,"Jones","Bob", "444-44-4444");
                
        // store them in a non-generified map (backward compatible)
        // implementations - Hashtable, HashMap and LinkedHashMap -- try all 3!
        Map map = new HashMap(); // edit this!
        map.put("333-33-3333", e1);
        map.put("111-11-1111", e2);
        
        // now retrieve one by its key
        Employee e = (Employee)map.get("111-11-1111");
        System.out.println("Retrieving employee with ssn: 111-11-1111: " + e);

        // when you overwrite a value the old value is returned with some map types
        Employee e_orig = (Employee)map.put("111-11-1111", e3);
        // now output to prove it works:
        System.out.println("Replacing Sally Smith with: " + e3);
        System.out.println("Original Employee entry: " + e_orig);

        // That's all there is to basic storage and retrieval.
        // But what if you want to loop through a Map? Well,
        // Maps are not sequential lists of objects. They are
        // randomly stored key-value pairs. Therefore, you can't
        // loop through the pairs, but you CAN loop through all
        // they keys or all the values:

        // Let's loop through the keys, retrieving each object
        // stored in the map by its key and print out it's toString value.
        // Keys must be unique so we should use a Set. Note
        // that the isertion order is NOT maintained:
        System.out.println("\nUsing a keyset, get the employees...");
        Set keys = map.keySet();
        for(Object key : keys) {
            Employee found = (Employee)map.get(key);
            System.out.println(found.toString());
        }

        // That wasn't too hard. But what if you want
        // only a collection of the values? It's not as
        // common, but easy to do. Remember, values are
        // not necessarily unique, so we don't need a Set.
        // Note that the insertion order is NOT maintained:
        System.out.println("\nUsing a collection of values, get the Employees...");
        Collection values = map.values();
        for(Object emp : values) {
            System.out.println((Employee)emp);
        }

        // Now that you've run this code, change the Map above
        // to a HashMap. Then re-run. No change, right? That's
        // because Hashtable and HashMap are based on the Map
        // interface, and thus, both behave the same way. But
        // HashMap is faster because it is NOT thread safe.
    }
}
