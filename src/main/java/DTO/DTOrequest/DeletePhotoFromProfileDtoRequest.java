package DTO.DTOrequest;

public class DeletePhotoFromProfileDtoRequest {

    private int idPhoto;
    private int idPhotographer;

    public DeletePhotoFromProfileDtoRequest(int idPhoto, int idPhotographer) {
        this.idPhoto = idPhoto;
        this.idPhotographer = idPhotographer;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setPathToFolderPhotos(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }
}
