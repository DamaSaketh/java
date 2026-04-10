// You can create your own exception by extending Exception (checked) or RuntimeException (unchecked
class AgeTooLowException extends Exception {
    public AgeTooLowException(String message) {
        super(message);
    }
}

class Voter {
    public void checkEligibility(int age) throws AgeTooLowException {
        if (age < 18) {
            throw new AgeTooLowException("Age must be 18 or above to vote");
        } else {
            System.out.println("Eligible to vote");
        }
    }
}

public class Custom{
    public static void main(String[] args) {
        Voter voter = new Voter();
        try {
            voter.checkEligibility(16);
        } catch (AgeTooLowException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}