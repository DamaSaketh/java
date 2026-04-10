import java.io.*;


class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', marks=" + marks + "}";
    }
}

public class Serialization {

    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String[] args) {

        Student student = new Student(101, "John", 85.5);

        try {
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(student);

            oos.close();
            fos.close();

            System.out.println("Object serialized successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    
        try {
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student deserializedStudent = (Student) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Object deserialized successfully.");
            System.out.println(deserializedStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}