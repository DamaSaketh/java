// An interface with only one abstract method
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

Calculator add = (a, b) -> a + b;
System.out.println(add.operate(5, 3)); 


// Built-in functional interfaces (java.util.function):

// Predicate<T>

// Function<T,R>

// Consumer<T>

// Supplier<T>