package sortable.maps;

import common.Employee;
import java.util.*;

public class ListOfMapsDemo {
    
    public static void main(String[] args) {
        /*
         * Often we need to collect data in the form of "records" as a 
         * "collection of records" to be used somewhere else. This may 
         * be due to a database or file lookup, e.g.
         * 
         * The trick is to keep the data structures generic at the point
         * of retrieval, so that our retrieval code can be as generic as
         * possible. Then, when the application needs to see the data
         * defined in a domain-specific way, we copy the data into a collection
         * of domain-specific entity objects. Here's an example...
         */
        
        // Pretend the following records were retrieved from a database or
        // file query... we'll simulate this by called a helper method
        List<Map<String,String>> records = getAllEmployees();
        // Next, we transfer the data into a domain-specific entity objects
        List<Employee> employees = new ArrayList<Employee>();
        for(Map<String,String> rec : records) {
            Employee emp = new Employee();
            emp.setEmpID(Integer.valueOf(rec.get("empID")));
            emp.setLastName(rec.get("lastName"));
            emp.setFirstName(rec.get("firstName"));
            emp.setSsn(rec.get("ssn"));
            employees.add(emp);
        }
        
        // OK, now prove it's all there, nice and easy to use...
        System.out.println("Here's a list of the employees retrieved...");
        for(Employee e : employees) {
            System.out.println(e);
        }
    }
 
    
    // Pretend query
    private static List<Map<String,String>> getAllEmployees() {
        // Simulates a generic collection of records
        List<Map<String,String>> records = new ArrayList<Map<String,String>>();
        // Simulates a single, generic record
        Map<String,String> rec = null;
        
        // Now pretend we're retrieving raw data that contains keys and values.
        // We can store those in a Map<String,String>
        rec = new HashMap<String,String>();
        rec.put("empID", "1");
        rec.put("lastName", "Mallay");
        rec.put("firstName", "Fred");
        rec.put("ssn", "222-22-2222");
        records.add(rec);
                
        rec = new HashMap<String,String>();
        rec.put("empID", "2");
        rec.put("lastName", "Smith");
        rec.put("firstName", "Sally");
        rec.put("ssn", "111-11-1111");
        records.add(rec);
        
        return records;
    }
}
