package DTO.DTOrequest;

public class PhotoAddInProfileDtoRequest {

    int idPhotographer;
    String imageBase64;

    public PhotoAddInProfileDtoRequest(int idPhotographer, String imageBase64) {
        this.idPhotographer = idPhotographer;
        this.imageBase64 = imageBase64;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public PhotoAddInProfileDtoRequest(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
