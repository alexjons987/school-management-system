public abstract class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String email;
    private String phoneNumber;

    public Person(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
