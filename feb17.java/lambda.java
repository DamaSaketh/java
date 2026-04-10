
// A lambda expression is a short way to write an anonymous
//  function (a function without a name).
// It is mainly used to implement a Functional Interface
//  (an interface with only one abstract method).//
import java.util.*;

public class lambda {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Raj", "Amit", "John");

        names.forEach(name -> System.out.println(name));

    }
}