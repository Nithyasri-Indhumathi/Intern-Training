import java.util.*;

interface observer{
    public void update(int i);
}
interface subject{
    public void add(observer ob);
    public void remove(observer ob);
    public void notify(ArrayList<observer> l);
}
class ecom implements subject{
      public int cost;
      ArrayList<observer> l=new ArrayList<observer>();
      public void add(observer ob){
        l.add(ob);
      }
      public void remove(observer ob){
        l.remove(ob);
      }
      public void notify(ArrayList<observer> l){
           for(observer i:l){
            i.update(cost);
           }
      }
      public void setcost(int c){
        this.cost=c;
        notify(l);
      }


}
class person implements observer{
    public int cost;
    public void update(int c){
        this.cost=c;
        System.out.println(cost);
    }
}
class person2 implements observer{
    public int cost;
    public void update(int c){
        this.cost=c;
        System.out.println(cost);
    }
}
public class observer_pattern {
    public static void main(String[] args){
         observer p=new person();
         observer p1=new person2();
         ecom e=new ecom();
         e.add(p);
         e.add(p1);
         e.setcost(100);
         e.remove(p1);
         e.setcost(200);

    }
}
