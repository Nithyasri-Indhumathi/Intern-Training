
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class UserInteraction{
    Scanner obj=new Scanner(System.in);
    Car[] c=new Car[6];
    HashMap<String,ArrayList<Integer>>m=new HashMap<String,ArrayList<Integer>>();
         public void getinp(){
        
           //user inputs
            System.out.println("Choose input medium like:console,csv");
            String inpt=obj.nextLine();
            inp_out_factory ip=new inp_out_factory();
            ip.inp(c,inpt);
      
            //map to store key-customer name and values-discount,final cost
           
            service_factory ser=new service_factory();
            ser.choose_service(c, m);
         }
         public void displayOutput(){
     
       //output
       System.out.println("Choose output medium like:console,csv");
            String outt=obj.nextLine();
            inp_out_factory op=new inp_out_factory();
            op.out(c,outt,m);
       
         }
}
