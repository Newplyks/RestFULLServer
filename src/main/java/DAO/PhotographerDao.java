package DAO;

import DTO.DTOrequest.*;
import DTO.DTOresponse.CategoriesDtoResponse;
import DTO.DTOresponse.RegistrationPhotographerDTOresponse;
import DTO.DTOresponse.ResultOperationDtoResponse;

import java.sql.SQLException;

public interface PhotographerDao extends UserDao {

    RegistrationPhotographerDTOresponse registration(RegistratonPhotogrpherDtoReauest rdtor) throws SQLException;
    ResultOperationDtoResponse authorization(AuthorizationPhotographerDtoRequest adtor) throws SQLException;
    ResultOperationDtoResponse deleteProfile(DeleteProfilePhotgrapherDtoRequest delete);
    ResultOperationDtoResponse updateProfile(ChangeProfilePhotographerDtoRequest pdtor);
    ResultOperationDtoResponse addPhotoInProfile(PhotoAddInProfileDtoRequest padr);
    ResultOperationDtoResponse deletePhotoFromProfile(DeletePhotoFromProfileDtoRequest padr);
    ResultOperationDtoResponse addCategoriesInProfile(AddCategoriesDtoRequest acdr);
    ResultOperationDtoResponse deleteGatFromProfile(DeleteCategoriesDtoRequest dcdr);
    ResultOperationDtoResponse getAllCategoriesForPhotographer(CategoriesDtoResponse cdr);

}
