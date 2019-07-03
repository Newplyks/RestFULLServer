package DTO.DTOresponse;

public class FullPhotoByPhotographerDtoResponse {
    String photoBase64;

    public FullPhotoByPhotographerDtoResponse(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }
}
