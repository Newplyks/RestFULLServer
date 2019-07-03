package service;

import DAOimpl.PhotographerDaoImpl;
import DTO.DTOrequest.*;
import DTO.DTOresponse.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;

public class Service implements IService  {

    private Gson gson = new Gson();
    private PhotographerDaoImpl photographerDao = new PhotographerDaoImpl();
    public Service() throws SQLException, ClassNotFoundException { }


    @Override
    public String registration(String json) {
        RegistratonPhotogrpherDtoReauest registratonPhotogrpherDtoReauest =
                gson.fromJson(json, RegistratonPhotogrpherDtoReauest.class);
        try {
            return gson.toJson(new PhotographerDaoImpl().registration(registratonPhotogrpherDtoReauest));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String authorization(String json) {
        AuthorizationPhotographerDtoRequest authorizationPhotographerDtoRequest =
                gson.fromJson(json, AuthorizationPhotographerDtoRequest.class);
        ResultOperationDtoResponse resultOperationDtoResponse =
                photographerDao.authorization(authorizationPhotographerDtoRequest);
        return  gson.toJson(resultOperationDtoResponse);
    }

    @Override
    public String deleteProfile(String json) {
        DeleteProfilePhotgrapherDtoRequest deleteProfilePhotgrapherDtoRequest =
                gson.fromJson(json, DeleteProfilePhotgrapherDtoRequest.class);
        ResultOperationDtoResponse resultOperationDtoResponse =
                photographerDao.deleteProfile(deleteProfilePhotgrapherDtoRequest);
        FolderPhotos.deleteFolder(deleteProfilePhotgrapherDtoRequest.getIdPhotographer());
        return  gson.toJson(resultOperationDtoResponse);
    }

    @Override
    public String updateProfile(String json) {
        ChangeProfilePhotographerDtoRequest changeProfilePhotographerDtoRequest =
                gson.fromJson(json, ChangeProfilePhotographerDtoRequest.class);
        ResultOperationDtoResponse resultOperationDtoResponse =
                photographerDao.updateProfile(changeProfilePhotographerDtoRequest);
        return  gson.toJson(resultOperationDtoResponse);
    }

    @Override
    public String addPhotoInProfile(String json) {
        PhotoAddInProfileDtoRequest photoAddInProfileDtoRequest =
                gson.fromJson(json, PhotoAddInProfileDtoRequest.class);
        ResultOperationDtoResponse resultOperationDtoResponse =
                photographerDao.addPhotoInProfile(photoAddInProfileDtoRequest);
        return  gson.toJson(resultOperationDtoResponse);
    }

    @Override
    public String deletePhotoFromProfile(String json) {
        DeletePhotoFromProfileDtoRequest deletePhotoFromProfileDtoRequest=
                gson.fromJson(json, DeletePhotoFromProfileDtoRequest.class);
        ResultOperationDtoResponse resultOperationDtoResponse =
                photographerDao.deletePhotoFromProfile(deletePhotoFromProfileDtoRequest);
        return  gson.toJson(resultOperationDtoResponse);
    }

    @Override
    public String getFullProfile(String json) {
        FullProfilePhotographerDtoRequest fullProfilePhotographerDtoRequest=
                gson.fromJson(json, FullProfilePhotographerDtoRequest.class);
        FullProfilePhotographerDtoResponse fullProfilePhotographerDtoResponse =
                photographerDao.getFullProfile(fullProfilePhotographerDtoRequest);
        return  gson.toJson(fullProfilePhotographerDtoResponse);
    }

    @Override
    public String getPhotographersByCat(String json) {
        PhotographersListDtoRequest photographersListDtoRequest=
                gson.fromJson(json, PhotographersListDtoRequest.class);
        PhotographersListDtoResponse photographersListDtoResponse =
                photographerDao.getListPhotographerByCat(photographersListDtoRequest);
        return  gson.toJson(photographersListDtoResponse);
    }

    @Override
    public String addCategoriesInProfile(String json) {
        AddCategoriesDtoRequest addCategoriesDtoRequest=
                gson.fromJson(json, AddCategoriesDtoRequest.class);
        ResultOperationDtoResponse photographersListDtoResponse =
                photographerDao.addCategoriesInProfile(addCategoriesDtoRequest);
        return  gson.toJson(photographersListDtoResponse);
    }

    @Override
    public String deleteCategoriesInProfile(String json) {
        DeleteCategoriesDtoRequest deleteCategoriesDtoRequest=
                gson.fromJson(json, DeleteCategoriesDtoRequest.class);
        ResultOperationDtoResponse resultOperationDtoResponse =
                photographerDao.deleteGatFromProfile(deleteCategoriesDtoRequest);
        return  gson.toJson(resultOperationDtoResponse);
    }

    @Override
    public String getAllCat() {
        CategoriesDtoResponse categoriesDtoResponse =
                photographerDao.getAllCat();
        return  gson.toJson(categoriesDtoResponse);
    }
}
