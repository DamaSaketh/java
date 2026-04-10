 class Engine {
    String type;
    int horsepower;

    Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    void displayEngineDetails() {
        System.out.println("Engine Type: " + type);
        System.out.println("Horsepower: " + horsepower);
    }


    String brand;
    Engine engine;  

    Engine(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    void displayCarDetails() {
        System.out.println("Car Brand: " + brand);
        engine.displayEngineDetails();
    }

    public static void main(String[] args) {

        Engine engine1 = new Engine("Diesel", 120);
        Engine car1 = new Engine("Hyundai", engine1);

        car1.displayCarDetails();
    }
}