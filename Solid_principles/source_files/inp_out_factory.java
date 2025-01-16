
//class to choose the correct input and output

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class inp_out_factory {
    Scanner obj=new Scanner(System.in);
    public void inp(Car[] c,String i){
   
         if(i.equals("console")){
              console_input m=new console_input();
              m.inp_console(c);
         }
         else if(i.equals("csv")){
            csv_input m=new csv_input();
            System.out.print("Enter filename:");
            String fn=obj.nextLine();
            m.inp_csv(c,fn);
         }
    }
    public void out(Car[] c,String o,    HashMap<String,ArrayList<Integer>>m){
        if(o.equals("console")){
            console_output m1=new console_output();
            m1.out_console(c,m);
        }
        else if(o.equals("csv")){
            csv_output m1=new csv_output();
            System.out.println("Enter filename to save:");
            String fn=obj.nextLine();
            m1.out_csv(c,m,fn);
        }
    }
}
