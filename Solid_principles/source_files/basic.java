import java.util.*;
//basic service class to find discount and final cost based on each customer and their car services implements single reponsibility principle and  implements poen closed principle
class basic  implements basic_service {
   
    public void calc_basic(Car obj,HashMap<String, ArrayList<Integer>> m){
           int cost=3599;
           int dis = (3 * cost) / 100;
           int finalcost=cost-dis;
           ArrayList<Integer> currentval = m.get(obj.vin);
           if (currentval!=null) {
            
            currentval.set(0,currentval.get(0)+dis);
            currentval.set(1,currentval.get(1)+finalcost);
         
        } else {
            currentval = new ArrayList<>();
            currentval.add(dis);
            currentval.add(finalcost);
           
        }
        m.put(obj.vin, currentval);
           
    }
}