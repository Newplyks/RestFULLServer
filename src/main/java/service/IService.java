package service;


import DTO.DTOrequest.*;
import DTO.DTOresponse.RegistrationPhotographerDTOresponse;
import DTO.DTOresponse.ResultOperationDtoResponse;

import java.io.IOException;
import java.sql.SQLException;

public interface IService {

    String registration(String json);
    String authorization(String json);
    String deleteProfile(String json);
    String updateProfile(String json);
    String addPhotoInProfile(String json);
    String deletePhotoFromProfile(String json);
    String getFullProfile(String json);
    String getPhotographersByCat(String json);
    String addCategoriesInProfile(String json);
    String deleteCategoriesInProfile(String json);
    String getAllCat();
}
