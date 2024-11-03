package backend;

public class Trainer extends User {
    private String trainerId;
    private String name;
    private String email;
    private String speciality;
    private String phoneNumber;

    // Constructor to initialize Trainer-specific and User fields
    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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