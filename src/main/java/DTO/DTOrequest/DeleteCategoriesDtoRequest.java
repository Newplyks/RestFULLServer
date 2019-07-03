package DTO.DTOrequest;

public class DeleteCategoriesDtoRequest {

    private int idCat;
    private int idPhotographer;

    public DeleteCategoriesDtoRequest(int idCat, int idPhotographer) {
        this.idCat = idCat;
        this.idPhotographer = idPhotographer;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }
}
