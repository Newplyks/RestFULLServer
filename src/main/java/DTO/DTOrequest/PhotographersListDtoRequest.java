package DTO.DTOrequest;

public class PhotographersListDtoRequest {

    int idCat;
    int indexLastPhotographer;

    public PhotographersListDtoRequest(int idCat, int indexLastPhotographer) {
        this.idCat = idCat;
        this.indexLastPhotographer = indexLastPhotographer;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }


    public int getIndexLastPhotographer() {
        return indexLastPhotographer;
    }

    public void setIndexLastPhotographer(int indexLastPhotographer) {
        this.indexLastPhotographer = indexLastPhotographer;
    }
}
