package DTO.DTOrequest;

public class ChangeProfilePhotographerDtoRequest {

    private  int idPhohtographer;
    private String about;
    private int priceForHour;
    private int priceForProject;

    public ChangeProfilePhotographerDtoRequest(int idPhohtographer, String about, int priceForHour, int priceForProject) {
        this.idPhohtographer = idPhohtographer;
        this.about = about;
        this.priceForHour = priceForHour;
        this.priceForProject = priceForProject;
    }

    public int getIdPhohtographer() {
        return idPhohtographer;
    }

    public void setIdPhohtographer(int idPhohtographer) {
        this.idPhohtographer = idPhohtographer;
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
