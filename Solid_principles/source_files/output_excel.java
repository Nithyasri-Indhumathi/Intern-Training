
//interfaces to choose output implements interface segreagation principle

import java.util.ArrayList;
import java.util.HashMap;

interface output_csv{
    public void out_csv(Car[] c,    HashMap<String,ArrayList<Integer>>m,String filename);
}