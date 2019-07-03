package DTO.DTOrequest;

public class RegistratonPhotogrpherDtoReauest {

    private String firstName;
    private String LastName;
    private String email;
    private String Password;

    public RegistratonPhotogrpherDtoReauest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        Password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
