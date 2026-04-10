import java.util.*;


class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}


class Patient extends Person {

    private final  int age;
    private Doctor assignedDoctor;

    public Patient(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void assignDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }
}
class HospitalSystem {

    private final String hospitalName;

    
    private final List<Doctor> doctors = new ArrayList<>();

    private final List<Patient> patients = new ArrayList<>();
    private final List<String> appointments = new ArrayList<>();

    public HospitalSystem(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void assignPatientToDoctor(int patientId, int doctorId) {

        Doctor selectedDoctor = null;
        Patient selectedPatient = null;

        for (Doctor d : doctors) {
            if (d.getId() == doctorId) {
                selectedDoctor = d;
                break;
            }
        }

        for (Patient p : patients) {
            if (p.getId() == patientId) {
                selectedPatient = p;
                break;
            }
        }

        if (selectedDoctor != null && selectedPatient != null) {

            selectedPatient.assignDoctor(selectedDoctor);

            appointments.add("Patient " + selectedPatient.getName() +
                    " assigned to " + selectedDoctor.getName() +
                    " (" + selectedDoctor.getSpecialization() + ")");

            System.out.println("Appointment created successfully.");
        } else {
            System.out.println("Doctor or Patient not found.");
        }
    }

    public void showAppointments() {
        System.out.println("\nAppointment List:");
        for (String a : appointments) {
            System.out.println(a);
        }
    }

    public void dischargePatient(int patientId) {

        Iterator<Patient> iterator = patients.iterator();

        while (iterator.hasNext()) {
            Patient p = iterator.next();

            if (p.getId() == patientId) {

                System.out.println("Patient " + p.getName() + " discharged.");
                iterator.remove();

                appointments.removeIf(a -> a.contains(p.getName()));
                return;
            }
        }

        System.out.println("Patient not found.");
    }
}
public class Hospital {

    public static void main(String[] args) {

        HospitalSystem hospital = new HospitalSystem("City Hospital");

        Doctor d1 = new Doctor(1, "Dr. Smith", "Cardiology");
        Doctor d2 = new Doctor(2, "Dr. John", "Neurology");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        Patient p1 = new Patient(101, "Alice", 30);
        Patient p2 = new Patient(102, "Bob", 45);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        hospital.assignPatientToDoctor(101, 1);
        hospital.assignPatientToDoctor(102, 2);

        hospital.showAppointments();

        hospital.dischargePatient(101);

        hospital.showAppointments();
    }
}

