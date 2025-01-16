
import java.util.*;
//class to choose the services
class service_factory{
    public void choose_service(Car[] c,HashMap<String, ArrayList<Integer>> m){
        for(int i=0;i<3;i++){
            ArrayList<String> ser=c[i].ServiceType;
            for(String s:ser){
                if(s.equals("Basic Service"))
                {
                    basic b=new basic();
                    b.calc_basic(c[i],m);
                }
                else if(s.equals("Oil Clean"))
                {
                    oil o=new oil();
                    o.calc_oil(c[i],m);
                }
                else if(s.equals("Parts Charge")){
                    parts p=new parts();
                    p.calc_parts(c[i],m);
                }

            }
        }
    }
}