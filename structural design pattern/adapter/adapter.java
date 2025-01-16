import java.util.*;
class employee{
public int id;
public String name;
public employee(int id,String name){
    this.id=id;
    this.name=name;
}
}
class datamodel{
  public void printing(ArrayList<employee> obj){
    for(employee i:obj){
    System.out.println(i.id);
    System.out.println(i.name);
    }
  }
}
class empadapter{

public ArrayList<employee> empopr(ArrayList<String> obj){
 
  ArrayList<employee> emps=new ArrayList<employee>();
  for (String data : obj) {
    String[] parts = data.split(",");
    int id = Integer.parseInt(parts[0]);
    String name = parts[1];
emps.add(new employee(id,name));

}
return emps;
}
}
public class adapter{
public static void main(String[] args){
ArrayList<String> new_data=new ArrayList<String>();
new_data.add("1,xx");
new_data.add("2,yy");
empadapter obj=new  empadapter();
ArrayList<employee> empl=obj.empopr(new_data);
datamodel dm=new datamodel();
dm.printing(empl);
}
}