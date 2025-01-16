
import java.util.ArrayList;
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

