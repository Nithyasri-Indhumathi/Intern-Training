//Singleton design patter-Synchronized

import java.io.*;

 class sample{
    //just declaring static object 
    public static sample obj;
    //private constructor
    private sample(){
        System.out.println("Intance created!");
    }
    //static synchronized(since thread are started simultaneously)to create and  return static obj
    public static synchronized sample getInstance(){
        //create obj if not already created
        if(obj==null){
        obj=new sample();
        }
        return obj;
    }
}
public class Main{
    public static void main(String[] args){
        //creating 2 objects using threads
        Thread t1=new Thread(new Runnable(){
            public void run(){
                 sample obj1=sample.getInstance();
            }
        });
         Thread t2=new Thread(new Runnable(){
            public void run(){
                 sample obj2=sample.getInstance();
            }
        });
        //both threads started at same time
        t1.start();
        t2.start();
    }
}