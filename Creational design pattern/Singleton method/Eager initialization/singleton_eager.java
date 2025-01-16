//Singleton design patter-Eager initialization

import java.io.*;

 class sample{
    //creating static object
    public static sample obj=new sample();
    //private constructor
    private sample(){
        System.out.println("Intance created!");
    }
    //static fun to return static obj
    public static sample getInstance(){
        return obj;
    }
}
public class Main{
    public static void main(String[] args){
        //creating 2 objects but it is created only once
        sample obj1=sample.getInstance();
        sample obj2=sample.getInstance();
    }
}