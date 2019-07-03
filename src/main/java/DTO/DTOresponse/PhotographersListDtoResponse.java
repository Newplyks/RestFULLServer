package DTO.DTOresponse;

import model.Photographer;

import java.util.List;

public class PhotographersListDtoResponse {

    List<Photographer> listPhotographers;
    String message;

    public PhotographersListDtoResponse(List<Photographer> listPhotographers, String message) {
        this.listPhotographers = listPhotographers;
        this.message = message;
    }

    public List<Photographer> getListPhotographers() {
        return listPhotographers;
    }

    public void setListPhotographers(List<Photographer> listPhotographers) {
        this.listPhotographers = listPhotographers;
    }

}
