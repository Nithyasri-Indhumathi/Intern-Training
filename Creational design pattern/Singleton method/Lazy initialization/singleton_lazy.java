//Singleton design patter-Lazy initialization

import java.io.*;

 class sample{
    //just declaring static object 
    public static sample obj;
    //private constructor
    private sample(){
        System.out.println("Intance created!");
    }
    //static fun to create and  return static obj
    public static sample getInstance(){
        //create obj if not already created
        if(obj==null){
        obj=new sample();
        }
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