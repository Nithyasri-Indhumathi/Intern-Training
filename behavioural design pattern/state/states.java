import java.io.*;
import java.util.*;
interface state{
    public state change(int i);
}
class write implements state{
    public state change(int i){
        if(i==1){
        System.out.println("In write state and success.. so move to next state");
        return new save();
       
        }
        else{
            System.out.println("In write state and failed.. so not move to next state");
        return new write();
        }
    }
}
class save implements state{
    public state change(int i){
       if(i==1){
        System.out.println("In save state and success.. so move to next state");
        return new print();
        }
        else{
            System.out.println("In save state and failed.. so not move to next state");
        return new save();
        }
    }
}
class print implements state{
    public state change(int i){
        if(i==1){
        System.out.println("In print state and success and completed");
        return this;
        }
        else{
            System.out.println("In print state and failed.. so not move to next state");
        return new save();
        }
    }
}
class doc{
     state s;
    public doc(){
        s=new write();
    }
   
    public void publish(int i){
        s=s.change(i);
       
    }
}
public class states{
    public static void main(String[] args){
        doc d=new doc();
        d.publish(1);
        d.publish(0);
        d.publish(1);
        d.publish(1);
    }
}