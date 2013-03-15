package common;

/* Week 15/16 Labs #2 - #4
 * @author dawn bykowski, dpaasch@my.wctc.edu
 * @version 1.00
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Startup {

    public static void main(String[] args) {

        // Lab Activity #2
        System.out.println("\t\t\tLab Activity #2");
        Employee e1 = new Employee(1, "Jones", "Tommy Lee", "111-22-3333");
        Employee e2 = new Employee(2, "Hackman", "Gene", "222-33-4444");
        Employee e3 = new Employee(3, "Witherspoon", "Reese", "333-44-5555");
        Employee e4 = new Employee(4, "Judd", "Ashley", "111-22-3333");

        Map<String, Employee> employeeHashMap = new HashMap<String, Employee>();
        employeeHashMap.put("111-22-3333", e1);
        employeeHashMap.put("222-33-4444", e2);
        employeeHashMap.put("333-44-5555", e3);
        employeeHashMap.put("111-22-3333", e4);

        System.out.println("\tRetrieve individual items from the HashMap");
        Employee eHash = (Employee) employeeHashMap.get("222-33-4444");
        System.out.println("Retrieved employee: " + eHash.getEmpID() + "\n" + eHash);

        System.out.println("\n\tLoop through the keys from the HashMap");
        Set<String> eKeys = employeeHashMap.keySet();
        for (String eKey : eKeys) {
            Employee eHashKey = employeeHashMap.get(eKey);
            System.out.println(eHashKey.toString());
        }
        System.out.println("\n\tLoop through the values from the HashMap");
        Collection<Employee> eValues = employeeHashMap.values();
        for (Employee eHashValue : eValues) {
            System.out.println(eHashValue.getLastName());
        }

        // Lab Activity #3
        System.out.println("\n\n\t\t\tLab Activity #3");
        Map<String, Employee> employeeTreeMap = new TreeMap<String, Employee>(employeeHashMap);

        System.out.println("\tUsing TreeMap.keySet() - non-sorted list");
        Set<String> eKeys2 = employeeTreeMap.keySet();
        // removes duplicate because used set of keySets rather than values on
        // treemap, using a treeset won't remove the duplicates. - There is no
        // sorting here...
        for (String eKey : eKeys2) {
            Employee eTreeKey = employeeTreeMap.get(eKey);
            System.out.println(eTreeKey.toString());
        }
        System.out.println("\n\tOverride compareTo() from the Comparable interface");
        Collection<Employee> treeMapValues = employeeTreeMap.values();
        List<Employee> eList = new ArrayList<Employee>(treeMapValues);
        Collections.sort(eList);
        for (Employee eTreeValue : eList) {
            System.out.println(eTreeValue);
        }
        System.out.println("\n\tUsing a Comparator from the GenericsAndMaps project");
        System.out.println("\t\t\t Comparator Last Name");
        Collection<Employee> treeMapValues2 = employeeTreeMap.values();
        List<Employee> eList2 = new ArrayList<Employee>(treeMapValues2);
        Collections.sort(eList2, new EmployeeByLastName());
        for (Employee eTreeValue2 : eList2) {
            System.out.println(eTreeValue2);
        }
        System.out.println("\t\t\t Comparator SSN");
        Collections.sort(eList2, new EmployeeBySsn());
        for (Employee eTreeValue2 : eList2) {
            System.out.println(eTreeValue2);
        }

        // Lab Activity #4
        System.out.println("\n\n\t\t\tLab Activity #4");
        List<Employee> employeeList = new ArrayList<Employee>(treeMapValues);

        System.out.println("\t\tDemonstrate that sorting works: natural ordering");
        Set<Employee> employeeTreeSet = new TreeSet<Employee>(employeeList);

        System.out.println("# Employees: " + employeeTreeSet.size());
        for (Employee eTreeSet : employeeTreeSet) {
            System.out.println(eTreeSet);
        }
        System.out.println("\t\tDuplicates are removed by looping through the set "
                + "using an iterator");
        Collections.sort(eList, new EmployeeBySsn());
        Iterator iterator = employeeTreeSet.iterator();
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next(); 
            //duplicates would be removed here
            System.out.println(employee);
            
       // One thing that puzzles me is why none of the maps/sets show all 4 employees.
       // I would suspect that the TreeSet would be the only one to remove the duplicates,
       // but maybe I just don't fully understand as I have not made it through all
       // the tutorial.
        }
    }
}
