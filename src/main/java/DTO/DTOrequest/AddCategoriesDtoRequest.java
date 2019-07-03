package DTO.DTOrequest;

public class AddCategoriesDtoRequest {

    int idCategories;
    int idPhotographer;

    public AddCategoriesDtoRequest(int idCategories, int idPhotographer) {
        this.idCategories = idCategories;
        this.idPhotographer = idPhotographer;
    }


    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public AddCategoriesDtoRequest(int idCategories) {
        this.idCategories = idCategories;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }
}
