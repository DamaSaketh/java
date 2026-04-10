

public class Csv {
    public static void main(String[] args) {
        String csvLine = "101,Ravi,50000";
        String[] parts = csvLine.split(",");
        if (parts.length == 3) {
            String id = parts[0];
            String name = parts[1];
            String salary = parts[2];
            System.out.println("ID:" + id + " Name:" + name + " Salary:" + salary);
        } else {
            System.out.println("Invalid CSV format.");
        }
    }
}