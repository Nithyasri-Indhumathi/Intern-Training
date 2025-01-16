//Builder design pattern

//Fcatory design pattern
import java.io.*;
import java.util.*;
//class with all members and 
class Computer{
    private String cpu;
    private String gpu;
    private String ram;
    private String harddisk;
    // Constructor to initialize all the fields
    public Computer(String cpu, String gpu, String ram, String harddisk) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.harddisk = harddisk;
    }
    // Override the toString method to print the values
    @Override
    public String toString(){
        return "Computer{cpu="+ cpu + " " + ", gpu=" +gpu + " " +", ram=" + ram + " " +", harddisk=" + harddisk + " " +"}";
    }
}

//Builder fuction to populate paramaters correctly and dynamically
class ComputerBuilder{
    private String cpu;
    private String gpu;
    private String ram;
    private String harddisk;
    
    //separately initaizing values one by one 
    public ComputerBuilder setcpu(String inp){
        this.cpu=inp;
        return this;
    }
     public ComputerBuilder setgpu(String inp){
        this.gpu=inp;
        return this;
    }
     public ComputerBuilder setram(String inp){
        this.ram=inp;
        return this;
    }
     public ComputerBuilder setharddisk(String inp){
        this.harddisk=inp;
        return this;
    }
    
    //Finally returing the object
    public Computer getComputer(){
        return new Computer(cpu,gpu,ram,harddisk);
    }
}
public class Main{
    public static void main(String[] args){
        
        
    //Creating object for builder function
      Computer c=new ComputerBuilder().setcpu("3.5 GHz").setram("200 GB").getComputer();
      System.out.println(c);
    }
}