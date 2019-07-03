package DTO.DTOresponse;

public class PhotoDeleteFromProfileDtoRequest {

    int idPhotographer;
    int idImage;

    public PhotoDeleteFromProfileDtoRequest(int idPhotographer, int idImage) {
        this.idPhotographer = idPhotographer;
        this.idImage = idImage;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
