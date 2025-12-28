package entity;

public class Student extends Person {
    private String batch;
    private boolean active;

    //Default constructor
    //public Student() {}

    //Parameterized constructor
    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id,firstName,lastName,email);
        this.batch = batch;
        this.active = active;
    }

    //overloaded constructor(without email)
    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super(id,firstName,lastName,null);
        this.batch=batch;
        this.active=active;
    }
    //getter and setter methods
    public String getBatch() { return batch; }
    public void setBatch(String batch) { this.batch=batch; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " (" + batch + ")";
    }
}
