package DTO.DTOrequest;

public class FullProfilePhotographerDtoRequest {
    int idPhotographer;


    public FullProfilePhotographerDtoRequest(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }
}
