import java.util.*;

class Employee {
    int id; String name;
    Employee(int id,String name){
        this.id=id; this.name=name;
    }
    public String toString(){
        return id+" "+name;
    }
}

public class EMS {
    public static void main(String[] args) {
        ArrayList<Employee> list=new ArrayList<>();

        list.add(new Employee(1,"Akash"));
        list.add(new Employee(2,"Kittu"));

        for(Employee e:list)
            System.out.println(e);
    }
}
