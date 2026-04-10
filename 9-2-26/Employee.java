
 public class Employee{
    String name;
    double salary;

    Employee(String name,double  salary) {
        this.name=name;
        this.salary=salary;

    }
    void displayDetails(){
        System.out.println("namr "+name);
        System.out.println("salary "+salary);
    }
    public static void main(String[] args) {

        Developer dev = new Developer("Saketh", 50000);
        Manager mgr = new Manager("Rahul", 80000);

        System.out.println("Developer Details:");
        dev.displayDetails();

        System.out.println("\nManager Details:");
        mgr.displayDetails();
    }
}

class Developer extends Employee{

    Developer(String name,double salary){
        super(name,salary);

    }
}
class Manager extends Employee{
    Manager(String name,double salary){
        super(name,salary);
    }
}


    
