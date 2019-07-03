package DTO.DTOrequest;

public class DeleteProfilePhotgrapherDtoRequest {

    private int idPhotographer;

    public DeleteProfilePhotgrapherDtoRequest(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }
}
