import java.io.*;
import java.util.*;

class csv_input implements input_csv {
    public void inp_csv(Car[] c, String filename) {
        System.out.println("Get input from CSV");

        String CustomerName;
        String Contact;
        String vin;
        String oem;
        int fuel;
        int mileage;
        String color;
        int n;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            int ind = 0;

            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Handle commas inside quotes
                String[] data = parseCSVLine(line);

                CustomerName = data[0];
                Contact = data[1];
                vin = data[2];
                oem = data[3];
                fuel = Integer.parseInt(data[4]);
                mileage = Integer.parseInt(data[5]);
                color = data[6];
                n = Integer.parseInt(data[7]);

                // Split ServiceType by commas and trim spaces
                String[] services = data[8].split(",");
                ArrayList<String> ServiceType = new ArrayList<>();
                for (String service : services) {
                    ServiceType.add(service.trim()); // Remove any leading/trailing spaces
                }

                // Create Car object and assign it to the array
                c[ind] = new Car(CustomerName, Contact, vin, oem, fuel, mileage, color, n, ServiceType);
                ind++;
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Helper function to properly split a CSV line considering quoted fields
    private String[] parseCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '"') {
              
                insideQuotes = !insideQuotes;
            } else if (ch == ',' && !insideQuotes) {
                // Add field to the list when comma is found outside quotes
                fields.add(currentField.toString().trim());
                currentField.setLength(0);
            } else {
                currentField.append(ch); // Add character to the current field
            }
        }

        // Add the last field
        fields.add(currentField.toString().trim());

        return fields.toArray(new String[0]);
    }
}
