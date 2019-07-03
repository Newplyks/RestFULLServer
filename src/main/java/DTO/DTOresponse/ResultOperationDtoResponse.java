package DTO.DTOresponse;

import service.RequestCode;

public class ResultOperationDtoResponse {

    RequestCode requestCode;
    String  result;
    int idPhotographer;

    public ResultOperationDtoResponse(RequestCode requestCode, String result, int idPhotographer) {
        this.requestCode = requestCode;
        this.result = result;
        this.idPhotographer = idPhotographer;
    }

    public ResultOperationDtoResponse(RequestCode requestCode, String result) {
        this.requestCode = requestCode;
        this.result = result;
    }

    public int getIdPhotographer() {
        return idPhotographer;
    }

    public void setIdPhotographer(int idPhotographer) {
        this.idPhotographer = idPhotographer;
    }

    public RequestCode getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(RequestCode requestCode) {
        this.requestCode = requestCode;
    }


    public ResultOperationDtoResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
