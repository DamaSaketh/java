import java.util.*;
public class task4 {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new FullTimeEmployee.Builder()
                .setName("Alice")
                .setMonthlySalary(50000)
                .build();

        Employee emp2 = new PartTimeEmployee.Builder()
                .setName("Bob")
                .setHourlyRate(500)
                .setHoursWorked(40)
                .build();

        Employee emp3 = new ContractEmployee.Builder()
                .setName("Charlie")
                .setContractAmount(30000)
                .build();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

 
        System.out.println("===== Payroll Report =====");

        double totalPayroll = 0;

        for (Employee emp : employees) {
            double salary = emp.calculateSalary();
            System.out.println(
                    "Type: " + emp.getType() +
                    " | Name: " + emp.getName() +
                    " | Salary: " + salary);
            totalPayroll += salary;
        }

        System.out.println("---------------------------");
        System.out.println("Total Payroll: " + totalPayroll);
    }
}



interface Employee {
    double calculateSalary();
    String getName();
    String getType();
}

class FullTimeEmployee implements Employee {

    private final  String name;
    private final  double monthlySalary;


    private FullTimeEmployee(Builder builder) {
        this.name = builder.name;
        this.monthlySalary = builder.monthlySalary;
    }
@Override
    public double calculateSalary() {
        return monthlySalary;
    }
@Override
    public String getName() {
        return name;
    }
@Override
    public String getType() {
        return "Full-Time";
    }


    public static class Builder {
        private String name;
        private double monthlySalary;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMonthlySalary(double monthlySalary) {
            this.monthlySalary = monthlySalary;
            return this;
        }

        public FullTimeEmployee build() {
            return new FullTimeEmployee(this);
        }
    }
}

class PartTimeEmployee implements Employee {

    private final String name;
    private  final double hourlyRate;
    private final  int hoursWorked;

    private PartTimeEmployee(Builder builder) {
        this.name = builder.name;
        this.hourlyRate = builder.hourlyRate;
        this.hoursWorked = builder.hoursWorked;
    }
@Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
@Override
    public String getName() {
        return name;
    }
@Override
    public String getType() {
        return "Part-Time";
    }

    public static class Builder {
        private String name;
        private double hourlyRate;
        private int hoursWorked;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public Builder setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
            return this;
        }

        public PartTimeEmployee build() {
            return new PartTimeEmployee(this);
        }
    }
}


class ContractEmployee implements Employee {

    private final String name;
    private final double contractAmount;

    private ContractEmployee(Builder builder) {
        this.name = builder.name;
        this.contractAmount = builder.contractAmount;
    }
@Override
    public final  double calculateSalary() {
        return contractAmount;
    }
@Override
    public String getName() {
        return name;
    }
@Override
    public String getType() {
        return "Contract";
    }

    public static class Builder {
        private String name;
        private double contractAmount;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setContractAmount(double contractAmount) {
            this.contractAmount = contractAmount;
            return this;
        }

        public ContractEmployee build() {
            return new ContractEmployee(this);
        }
    }
}

