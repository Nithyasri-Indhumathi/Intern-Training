
//class with functions for different outputs

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

class csv_output implements output_csv{
    public void out_csv(Car[] c,    HashMap<String,ArrayList<Integer>>m,String filename){
        System.out.println("Get output in excel");
        

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Customer Name,Contact,VIN,OEM,Fuel,Mileage,Service Type,Discount,Final Cost");
            writer.newLine(); 
            for(int i=0;i<3;i++){
                String customerName = c[i].CustomerName;
                String contact = c[i].Contact;
                String vin = c[i].vin;
                String oem = c[i].oem;
                int fuel = c[i].fuel;
                int mileage = c[i].mileage;
                String serviceTypes = String.join(",", c[i].ServiceType);
                ArrayList<Integer> costs=m.get(c[i].vin);
                if (costs == null) {
                    costs = new ArrayList<>();
                    costs.add(0);  // Default Discount
                    costs.add(0);  // Default Final Cost
                }
                String row = String.format("%s,%s,%s,%s,%d,%d,%s,%d,%d", 
                                           customerName, contact, vin, oem, fuel, 
                                           mileage, serviceTypes, costs.get(0), costs.get(1));

                writer.write(row);
                writer.newLine();
            }
            System.out.println("CSV file created successfully!");

        }
        catch(IOException e){
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }


    }
}