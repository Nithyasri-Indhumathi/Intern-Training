
interface food{
    public String getresults();
    public int getcost();
}
class breakfast implements food{
    public String getresults(){
        return "breakfast";
    }
    public int getcost(){
       return 123;
    }
}
class lunch implements food{
    public String getresults(){
       return "lunch";
    }
    public int getcost(){
        return 1234;
    }
}
abstract class decorator_food implements food{
    // protected food f;
    // public decorator_food(food obj){
    //     this.f=obj;
    // }
   public abstract String getresults();
   
   
   public abstract int  getcost();
   
   
}
class extended_decorator extends decorator_food{
    protected food f;
    public extended_decorator(food obj){
        this.f=obj;
    }
   public String getresults(){
    return f.getresults()+" add on";
   }
   public int  getcost(){
    return f.getcost()+100;
   }
}
public class decorator {
    public static void main(String[] args){
        breakfast ob=new breakfast();
        System.out.println(ob.getresults());
        System.out.println(ob.getcost());
        extended_decorator ad=new extended_decorator(ob);
        System.out.println(ad.getresults());
        System.out.println(ad.getcost());
        lunch l=new lunch();
        System.out.println(l.getresults());
        System.out.println(l.getcost());
        extended_decorator ad1=new extended_decorator(l);
        System.out.println(ad1.getresults());
        System.out.println(ad1.getcost());
    }
}
