package DTO.DTOrequest;

public class PersonalCategoryDtoRequest {

    int idPhotographer;

    public PersonalCategoryDtoRequest(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }
}
