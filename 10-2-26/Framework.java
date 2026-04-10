import java.lang.annotation.*;
import java.lang.reflect.*;

public class Framework {

    public static void main(String[] args) throws Exception {

        OrderService orderService = new OrderServiceImpl();
        UserService userService = new UserServiceImpl();

        processAnnotations(orderService);
        processAnnotations(userService);
    }

    public static void processAnnotations(Object service) throws Exception {

        Class<?> clazz = service.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                method.invoke(service);  
                long end = System.nanoTime();

                System.out.println("Execution time of " + method.getName() +
                        ": " + (end - start)/1_000_000 + " ms\n");
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

interface OrderService {
    void createOrder();
    void cancelOrder();
}

interface UserService {
    void registerUser();
    void deleteUser();
}

class OrderServiceImpl implements OrderService {

    @LogExecutionTime
    public void createOrder() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println("Order created successfully.");
    }

    public void cancelOrder() {
        System.out.println("Order cancelled.");
    }
}

class UserServiceImpl implements UserService {

    @LogExecutionTime
    public void registerUser() {
        try { Thread.sleep(150); } catch (InterruptedException e) {}
        System.out.println("User registered successfully.");
    }

    public void deleteUser() {
        System.out.println("User deleted.");
    }
}
