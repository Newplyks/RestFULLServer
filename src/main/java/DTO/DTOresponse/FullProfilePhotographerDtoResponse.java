package DTO.DTOresponse;

public class FullProfilePhotographerDtoResponse {

    private String firstName;
    private String LastName;
    private String email;
    private String about;
    private int priceForHour;
    private int priceForProject;
    String[] imageStringBase64;


    public FullProfilePhotographerDtoResponse(String firstName, String lastName, String email, String about, int priceForHour, int priceForProject, String[] imageStringBase64) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.about = about;
        this.priceForHour = priceForHour;
        this.priceForProject = priceForProject;
        this.imageStringBase64 = imageStringBase64;
    }

    public FullProfilePhotographerDtoResponse(String firstName, String lastName, String email,
                                              String about, int priceForHour, int priceForProject) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.about = about;
        this.priceForHour = priceForHour;
        this.priceForProject = priceForProject;
    }

    public String[] getImageStringBase64() {
        return imageStringBase64;
    }

    public void setImageStringBase64(String[] imageStringBase64) {
        this.imageStringBase64 = imageStringBase64;
    }

    public FullProfilePhotographerDtoResponse(){};


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
