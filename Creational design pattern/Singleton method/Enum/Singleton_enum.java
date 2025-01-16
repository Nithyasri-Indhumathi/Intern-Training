//Singleton design patter-enum
import java.io.*;
//special type of class-have private constructor always
enum sample{
    //in built private constructor
    INSTANCE;
    int i;
    public void show(){
        System.out.println(i);
    }

}
public class Main{
    public static void main(String[] args){
        //creating 2 objects
        sample obj1=sample.INSTANCE;
        obj1.i=5;
        obj1.show();
         sample obj2=sample.INSTANCE;
        obj2.i=6;
        obj2.show();
    }
}