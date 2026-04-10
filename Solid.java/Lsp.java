public class Lsp {
    public static void main(String[] args) {

        Bird sparrow = new Sparrow();
        sparrow.eat();

        if (sparrow instanceof Flyable) {
            ((Flyable) sparrow).fly();
        }

        Bird penguin = new Penguin();
        penguin.eat();

    }
}
abstract class Bird {
    abstract void eat();
}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {

    @Override
    void eat() {
        System.out.println("Sparrow is eating.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}

class Penguin extends Bird {

    @Override
    void eat() {
        System.out.println("Penguin is eating.");
    }

}

