
//class with functions for different outputs

import java.util.ArrayList;
import java.util.HashMap;

class console_output implements output_console{
    public void out_console(Car[] c, HashMap<String, ArrayList<Integer>> m) {
        System.out.println("Get output in console");
        System.out.printf("%-20s %-12s %-15s %-8s %-6s %-10s %-25s %-10s %-10s%n", 
                          "Customer Name", "Contact", "VIN", "OEM", "Fuel", "Mileage", 
                          "Service Type", "Discount", "Final Cost");
        System.out.println("----------------------------------------------------------------------------------------------");
    
        for (int i = 0; i < 3; i++) {
            // Format each column to align properly
            String customerName = c[i].CustomerName;
            String contact = c[i].Contact;
            String vin = c[i].vin;
            String oem = c[i].oem;
            int fuel = c[i].fuel;
            int mileage = c[i].mileage;
            String color=c[i].color;
            String serviceTypes = String.join(",", c[i].ServiceType);
            ArrayList<Integer> costs = m.get(c[i].vin);
          
            // Printing each row with proper column width formatting
            System.out.printf("%-20s %-12s %-15s %-8s %-6d %-10d %-25s %-10d %-10d%n", 
                              customerName, contact, vin, oem, fuel, mileage, 
                              serviceTypes, costs.get(0), costs.get(1));
        }
    }
    
    
}
