public class Dip {
    public static void main(String[] args) {

        Database mysql = new MySQLDatabase();
        UserService userService1 = new UserService(mysql);
        userService1.saveUser("Alice");

        
        Database postgres = new PostgreSQLDatabase();
        UserService userService2 = new UserService(postgres);
        userService2.saveUser("Bob");
    }
}
interface Database {
    void connect();
    void save(String name);
}


class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }

    @Override
    public void save(String name) {
        System.out.println("User " + name + " saved in MySQL");
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to PostgreSQL database");
    }

    @Override
    public void save(String name) {
        System.out.println("User " + name + " saved in PostgreSQL");
    }
}


class UserService {
    private Database db;

    public UserService(Database db) { 
        this.db = db;
    }

    public void saveUser(String name) {
        db.connect();
        db.save(name);
    }
}

