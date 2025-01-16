import java.io.*;
import java.util.*;
interface Teacher{
    public void marks();
}
class English implements Teacher{
    public void marks(){
        System.out.println("English marks:88");
    }
}
class Maths implements Teacher{
    public void marks(){
        System.out.println("Maths marks:99");
    }
}
class representative{
    public void eng_marks(){
        English e=new English();
        e.marks();
    }
    public void mat_marks(){
        Maths m=new Maths();
        m.marks();
    }
}
public class facade{
    public static void main(String[] args){
        representative r=new representative();
        r.eng_marks();
        r.mat_marks();
    }
}
