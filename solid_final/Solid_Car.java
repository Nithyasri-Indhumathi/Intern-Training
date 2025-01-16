import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


class Car{
    public String CustomerName;
    public String  Contact;
    public String vin;
    public String oem;
    public int fuel;
    public int mileage;
    public String color;
    public int n;
    public ArrayList<String> ServiceType=new ArrayList<String>();
    public Car(String CustomerName,String  Contact,String vin,String oem,int fuel,int mileage,String color,int n,ArrayList<String> ServiceType){
               this.CustomerName=CustomerName;
               this.Contact=Contact;
               this.vin=vin;
               this.oem=oem;
               this.fuel=fuel;
               this.mileage=mileage;
               this.color=color;
               this.ServiceType=ServiceType;
    }
}

//interfaces to choose input implements interface segreagation principle
interface input_console{
    public void inp_console();
}
interface input_excel{
    public void inp_excel();
}
//interfaces to choose output implements interface segreagation principle
interface output_console{
    public void out_console();
}
interface output_excel{
    public void out_excel();
}
//classs with functions for diff inputs implements poen closed principle
class console_input implements input_console{
    public void inp_console(){
        System.out.println("Get input from console");
    }
}
class excel_input implements input_excel{
    public void inp_excel(){
        System.out.println("Get input from excel");
    }
}

//class with functions for different outputs
class console_output implements output_console{
    public void out_console(){
        System.out.println("Get output inconsole");
    }
}
class excel_output implements output_excel{
    public void out_excel(){
        System.out.println("Get output in excel");
    }
}
//3 interfaces for 3 differnt services implemps lsp,isp
interface basic_service{
    public void calc_basic(Car obj,HashMap<String, ArrayList<Integer>> m);
}
interface oil_Clean{
    public void calc_oil(Car obj,HashMap<String, ArrayList<Integer>> m);
}
interface parts_charge{
    public void calc_parts(Car obj,HashMap<String, ArrayList<Integer>> m);
}

//basic service class to find discount and final cost based on each customer and their car services implements single reponsibility principle and  implements poen closed principle
class basic  implements basic_service {
   
    public void calc_basic(Car obj,HashMap<String, ArrayList<Integer>> m){
           int cost=3599;
           int dis = (3 * cost) / 100;
           int finalcost=cost-dis;
           ArrayList<Integer> currentval = m.get(obj.vin);
           if (currentval!=null) {
            
            currentval.set(0,currentval.get(0)+dis);
            currentval.set(1,currentval.get(1)+finalcost);
         
        } else {
            currentval = new ArrayList<>();
            currentval.add(dis);
            currentval.add(finalcost);
           
        }
        m.put(obj.vin, currentval);
           
    }
}

//oil clean service class to find discount and final cost based on each customer and their car services implements single reponsibility principle and  implements poen closed principle
class oil  implements oil_Clean {
   
    public void calc_oil(Car obj,HashMap<String, ArrayList<Integer>> m){
           
        int cost=2749;
           int dis = (1 * cost) / 100;
           int finalcost=cost-dis;
           ArrayList<Integer> currentval = m.get(obj.vin);
           if (currentval!=null) {
            
            currentval.set(0,currentval.get(0)+dis);
            currentval.set(1,currentval.get(1)+finalcost);
         
        } else {
            currentval = new ArrayList<>();
            currentval.add(dis);
            currentval.add(finalcost);
    }
    m.put(obj.vin, currentval);
}
}

//Parts change service class to find discount and final cost based on each customer and their car services implements single reponsibility principle and  implements poen closed principle
class parts  implements parts_charge {
    
    public void calc_parts(Car obj,HashMap<String, ArrayList<Integer>> m){
        int cost=32499;
           int dis = ( 5* cost) / 100;
           int finalcost=cost-dis;
           ArrayList<Integer> currentval = m.get(obj.vin);
           if (currentval!=null) {
            
            currentval.set(0,currentval.get(0)+dis);
            currentval.set(1,currentval.get(1)+finalcost);
         
        } else {
            currentval = new ArrayList<>();
            currentval.add(dis);
            currentval.add(finalcost);
           
    }
    m.put(obj.vin, currentval);
}
}

//class to choose the correct input and output
class inp_out_factory {
    public void inp(String i){
         if(i.equals("console")){
              console_input m=new console_input();
              m.inp_console();
         }
         else if(i.equals("excel")){
            excel_input m=new excel_input();
            m.inp_excel();
         }
    }
    public void out(String o){
        if(o.equals("console")){
            console_output m1=new console_output();
            m1.out_console();
        }
        else if(o.equals("excel")){
            excel_output m1=new excel_output();
            m1.out_excel();
        }
    }
}

//class to choose the services
class service_factory{
    public void choose_service(Car[] c,HashMap<String, ArrayList<Integer>> m){
        for(int i=0;i<3;i++){
            ArrayList<String> ser=c[i].ServiceType;
            for(String s:ser){
                if(s.equals("Basic Service"))
                {
                    basic b=new basic();
                    b.calc_basic(c[i],m);
                }
                else if(s.equals("Oil Clean"))
                {
                    oil o=new oil();
                    o.calc_oil(c[i],m);
                }
                else if(s.equals("Parts Charge")){
                    parts p=new parts();
                    p.calc_parts(c[i],m);
                }

            }
        }
    }
}
class UserInteraction{
    Car[] c=new Car[6];
    HashMap<String,ArrayList<Integer>>m=new HashMap<String,ArrayList<Integer>>();
         public void getinp(){
            String CustomerName;
            String  Contact;
            String vin;
            String oem;
            int fuel;
            int mileage;
            String color;
            int n;
            Scanner obj=new Scanner(System.in);
          
            
           //user inputs
            System.out.println("Choose input medium like:console,csv,excel,json");
            String inpt=obj.nextLine();
            inp_out_factory ip=new inp_out_factory();
            ip.inp(inpt);
            System.out.println("Choose output medium like:console,csv,excel,json");
            String outt=obj.nextLine();
            inp_out_factory op=new inp_out_factory();
            op.out(outt);
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
    
            //map to store key-customer name and values-discount,final cost
           
            service_factory ser=new service_factory();
            ser.choose_service(c, m);
         }
         public void displayOutput(){
               
     
       //output
    System.out.println("Customer Name  | Contact  | VIN      | OEM    | Fuel  | Mileage   | Service Type    | Discount  | Final Cost");
       for(int i=0;i<3;i++){
        System.out.print(c[i].CustomerName+"        |");
        System.out.print(c[i].Contact+"     |");
        System.out.print(c[i].vin+"     |");
        System.out.print(c[i].oem+"     |");
        System.out.print(c[i].fuel+"        |");
        System.out.print(c[i].mileage+"            |");
        String ser_list=String.join(",",c[i].ServiceType);
        System.out.print(ser_list + " | ");
        ArrayList<Integer> costs = m.get(c[i].vin);
        System.out.print(costs.get(0) + "       | " + costs.get(1));
        System.out.println();
       }

 
          
         }
}

public class Solid_Car {
    public static void main(String[] args){
        UserInteraction ui = new UserInteraction();
        ui.getinp();
        ui.displayOutput();
    }
}
