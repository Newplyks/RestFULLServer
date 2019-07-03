package DTO.DTOresponse;

import service.RequestCode;

public class RegistrationPhotographerDTOresponse {

    private RequestCode requestCode;
    private String message;
    private int idPhotographer;

    public RegistrationPhotographerDTOresponse(RequestCode requestCode, String message, int idPhotographer) {
        this.requestCode = requestCode;
        this.message = message;
        this.idPhotographer = idPhotographer;
    }


    public RequestCode getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(RequestCode requestCode) {
        this.requestCode = requestCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }
}
