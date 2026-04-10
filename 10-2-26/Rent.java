import java.util.*;

public class Rent {
    public static void main(String[] args) {

        RentalSystem rentalSystem = new RentalSystem();

        rentalSystem.addVehicle(new Car("C101", "Toyota"));
        rentalSystem.addVehicle(new Bike("B201", "Honda"));
        rentalSystem.addVehicle(new Truck("T301", "Volvo"));

        rentalSystem.rentVehicle("C101", 3);

        System.out.println("\n--- Multi-threaded Booking Simulation ---");

        Thread t1 = new BookingThread(rentalSystem, "B201", 2);
        Thread t2 = new BookingThread(rentalSystem, "B201", 4);

        t1.start();
        t2.start();
    }
}



abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected boolean isRented;

    public Vehicle(String vehicleId, String brand) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.isRented = false;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(vehicleId + " rented successfully.");
        } else {
            System.out.println(vehicleId + " is already rented.");
        }
    }

    public abstract double calculateRentalPrice(int days);
}


class Car extends Vehicle {
    private static final double DAILY_RATE = 50;

    public Car(String vehicleId, String brand) {
        super(vehicleId, brand);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return DAILY_RATE * days;
    }
}


class Bike extends Vehicle {
    private static final double DAILY_RATE = 20;

    public Bike(String vehicleId, String brand) {
        super(vehicleId, brand);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return DAILY_RATE * days;
    }
}


class Truck extends Vehicle {
    private static final double DAILY_RATE = 100;

    public Truck(String vehicleId, String brand) {
        super(vehicleId, brand);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return DAILY_RATE * days;
    }
}

class RentalSystem {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public synchronized void rentVehicle(String vehicleId, int days) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(vehicleId)) {
                if (!v.isRented()) {
                    v.rent();
                    System.out.println("Rental Price: $" + v.calculateRentalPrice(days));
                } else {
                    System.out.println("Vehicle already rented.");
                }
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }
}


class BookingThread extends Thread {
    private final RentalSystem rentalSystem;
    private final String vehicleId;
    private final int days;

    public BookingThread(RentalSystem rentalSystem, String vehicleId, int days) {
        this.rentalSystem = rentalSystem;
        this.vehicleId = vehicleId;
        this.days = days;
    }

    @Override
    public void run() {
        rentalSystem.rentVehicle(vehicleId, days);
    }
}



