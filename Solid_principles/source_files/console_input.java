
//classs with functions for diff inputs implements poen closed principle

import java.util.ArrayList;
import java.util.Scanner;

class console_input implements input_console{
    
    public void inp_console(Car[] c ){
        
         String CustomerName;
            String  Contact;
            String vin;
            String oem;
            int fuel;
            int mileage;
            String color;
            int n;
            Scanner obj=new Scanner(System.in);
        System.out.println("Get input from console");
        for(int i=0;i<3;i++){
                System.out.println("Enter name:");
                CustomerName=obj.nextLine();
                System.out.println("Enter contact:");
                Contact=obj.nextLine();
                System.out.println("Enter VIN:");
                vin=obj.nextLine();
                System.out.println("Enter OEM:");
                oem=obj.nextLine();
                System.out.println("Enter fuel:");
                fuel=obj.nextInt();
                System.out.println("Enter mileage:");
                mileage=obj.nextInt();
                System.out.println("Enter color:");
                color=obj.nextLine();
                System.out.println("Enter no.of services:");
                n=obj.nextInt();
                obj.nextLine();
                ArrayList<String> ServiceType = new ArrayList<>();
                
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter Service Type:");
                    String service = obj.nextLine();
                    ServiceType.add(service);
                }
    
                c[i]=new Car(CustomerName,Contact,vin,oem,fuel,mileage,color,n,ServiceType);
                
            }
          
    }
}