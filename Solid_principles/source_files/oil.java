import java.util.*;
//oil clean service class to find discount and final cost based on each customer and their car services implements single reponsibility principle and  implements poen closed principle
class oil  implements oil_Clean {
   
    public void calc_oil(Car obj,HashMap<String, ArrayList<Integer>> m){
           
        int cost=2749;
           int dis = (1 * cost) / 100;
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
