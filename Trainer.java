package trainer;

public class Trainer extends User {
    
    private String trainerId;
    private String speciality;

    // Constructor to initialize Trainer-specific and User fields
    public Trainer(String name, String email, String phoneNumber, String trainerId, String speciality) {
        super(name, email, phoneNumber);
        this.trainerId = trainerId;
        this.speciality = speciality;
    }
    
    // Method to represent the Trainer as a CSV string
    @Override
    public String lineRepresentation() {
        return this.trainerId + "," + this.name + "," + this.email + "," + this.speciality + "," + this.phoneNumber;
    }

    // Method to get the search key
    @Override
    public String getSearchKey() {
        return this.trainerId;
    }
}