//Factory design pattern

import java.io.*;
import java.util.*;

//Transport interface

interface Transport{
    void type();
}

// subclass for Truck

 class Truck implements Transport{
    public void type(){
        System.out.println("In Truck Transport service");
    }
}

// subclass for Ship

class Ship implements Transport{
    public void type(){
        System.out.println("In Ship Transport service");
    }
}

//Factory method for Transport to instantiate object dynamically

 class TransportFactory{
    public Transport getInstance(String a ){
        if(a.equals("Truck")){
            return new Truck();
        }
        else{
            return new Ship();
        }
    }
}

public class Main{
    public static void main(String[] args){
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter Truck to use truck service or Ship to use ship service");
        String ip=inp.nextLine();

//Create object for Factory method

        TransportFactory tf=new TransportFactory();

//Crete object object based on user input and call function called type

        Transport obj=tf.getInstance(ip);
        obj.type();
    }
}