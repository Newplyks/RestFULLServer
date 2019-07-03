package model;

public class Photographer {

    private int id;
    private String firstName;
    private String LastName;
    private String email;
    private String Password;
    private String about;
    private int priceForHour;
    private int priceForProject;

    public Photographer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Photographer(int id, String firstName, String lastName, String email, String password, String about, double rating,
                        int priceForHour, int priceForProject) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        Password = password;
        this.about = about;
        this.priceForHour = priceForHour;
        this.priceForProject = priceForProject;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public int getPriceForHour() {
        return priceForHour;
    }

    public void setPriceForHour(int priceForHour) {
        this.priceForHour = priceForHour;
    }

    public int getPriceForProject() {
        return priceForProject;
    }

    public void setPriceForProject(int priceForProject) {
        this.priceForProject = priceForProject;
    }

}
