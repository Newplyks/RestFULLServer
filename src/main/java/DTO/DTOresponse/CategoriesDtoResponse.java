package DTO.DTOresponse;

import model.Category;
import service.RequestCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CategoriesDtoResponse {

    List<Category> categories;
    RequestCode requestCode;

    public CategoriesDtoResponse(List<Category> categories, RequestCode requestCode) {
        this.categories = categories;
        this.requestCode = requestCode;
    }

    public RequestCode getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(RequestCode requestCode) {
        this.requestCode = requestCode;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
