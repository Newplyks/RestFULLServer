package DAOimpl;

import DAO.PhotographerDao;
import DTO.DTOrequest.*;
import DTO.DTOresponse.*;
import model.Category;
import model.Photographer;
import service.FolderPhotos;
import service.RequestCode;
import service.Setting;
import service.SqlString;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotographerDaoImpl implements PhotographerDao {

    private Connection connection;

    public PhotographerDaoImpl() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection  = DriverManager.getConnection(Setting.url,Setting.login,Setting.password);
    }

    public RegistrationPhotographerDTOresponse registration(RegistratonPhotogrpherDtoReauest rdtor){
        ResultSet resultSet;
        int idPhotographer = -1;
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlValidataEmail)){
            statement.setString(1, rdtor.getEmail());
            int count=1;
            resultSet = statement.executeQuery();
            if(resultSet.next()){
               count = resultSet.getInt(1);
            }
            if(count!=0){
                return new RegistrationPhotographerDTOresponse(RequestCode.EMAIL_ALREADY_EXISTS, "Emai already exist", -1);
            }
        } catch (SQLException e) {
            return new RegistrationPhotographerDTOresponse(RequestCode.ERROR_DATA_BASE,"Error BD", -1);
        }
        int res=0;
        String query = "INSERT INTO `rgr`.`photographers`(`first name`,`last name`,`email photographer`, `password`)" +
        " VALUES('"+rdtor.getFirstName()+"','"+rdtor.getLastName()+"','"+rdtor.getEmail()+"','"+rdtor.getPassword()+"')";
        try {
            Statement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
             ((PreparedStatement) statement).executeUpdate();
             ResultSet resultSet1 = statement.getGeneratedKeys();
             if(resultSet1.next()){
                 res = resultSet1.getInt(1);
             }
                resultSet1.close();
             statement.close();
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(res>0){
            FolderPhotos.CreateFolderForPhotographer(res);
            return  new RegistrationPhotographerDTOresponse(RequestCode.OPERATION_SUCCESSFUL,"Registration successful", idPhotographer);
        }
        else {
            return new RegistrationPhotographerDTOresponse(RequestCode.ERROR_DATA_BASE,"Error BD", -1);
        }
/*
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlRegisterPhotographer)){
            statement.setNString(1,rdtor.getFirstName());
            statement.setNString(2, rdtor.getLastName());
            statement.setNString(3, rdtor.getEmail());
            statement.setNString(4, rdtor.getPassword());
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                idPhotographer=resultSet.getInt(1);
            }
            else {
                return new RegistrationPhotographerDTOresponse(RequestCode.ERROR_DATA_BASE,"Ошибка БД", -1);
            }
            FolderPhotos.CreateFolderForPhotographer(idPhotographer);
            return  new RegistrationPhotographerDTOresponse(RequestCode.OPERATION_SUCCESSFUL,"Регистрация прошла успешно", idPhotographer);
        } catch (SQLException e) {
            return new RegistrationPhotographerDTOresponse(RequestCode.ERROR_DATA_BASE,"Ошибка БД", -1);
        }*/
    }

    public ResultOperationDtoResponse authorization(AuthorizationPhotographerDtoRequest adtor) {

        String idPhotographer;
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlAuthorization)){
            statement.setNString(1, adtor.getEmail());
            statement.setNString(2, adtor.getPassword());
            int count;
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "Successful",
                        resultSet.getInt(1));
            }
            else{
                return new ResultOperationDtoResponse(RequestCode.INVALID_LOGIN_OR_PASSWORD, "Invalid login or password");
            }
        } catch (SQLException e) {
            return new ResultOperationDtoResponse(RequestCode.ERROR_DATA_BASE, "Error BD....");
        }
    }

    public ResultOperationDtoResponse deleteProfile(DeleteProfilePhotgrapherDtoRequest delete) {
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlDeleteProfile)){
            statement.setInt(1, delete.getIdPhotographer());
            statement.execute();
            int count = 0;
            return new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "Profile was delete");
        } catch (SQLException e) {
            return new ResultOperationDtoResponse(RequestCode.ERROR_DATA_BASE,"Error BD");
        }
    }


    @Override
    public ResultOperationDtoResponse updateProfile(ChangeProfilePhotographerDtoRequest pdtor) {

        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlUpdateProfile)){
            statement.setNString(1, pdtor.getAbout());
            statement.setInt(2, pdtor.getPriceForHour());
            statement.setInt(3, pdtor.getPriceForProject());
            statement.setInt(4, pdtor.getIdPhohtographer());

            int result =0;
            if(statement.executeUpdate()>0){
                return  new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "Profile was change");
            }
            else {
                return  new ResultOperationDtoResponse(RequestCode.OPERATION_ERROR, "Error BD");
            }
        } catch (SQLException e) {
            return new ResultOperationDtoResponse(RequestCode.ERROR_DATA_BASE, "Error BD");
        }
    }

    public ResultOperationDtoResponse addPhotoInProfile(PhotoAddInProfileDtoRequest padr) {

        try{
            if(FolderPhotos.addPhotoInProfile(padr.getIdPhotographer(), padr.getImageBase64())){
                return new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "Photo added");
            }
            else {
                return new ResultOperationDtoResponse(RequestCode.OPERATION_ERROR, "Photo not add");
            }
        }catch (NullPointerException ex){
            return new ResultOperationDtoResponse(RequestCode.OPERATION_ERROR, "Photo not add");
        }


    }

    public ResultOperationDtoResponse deletePhotoFromProfile(DeletePhotoFromProfileDtoRequest padr) {
        if(FolderPhotos.deletePhotoFromProfile(padr.getIdPhotographer(), padr.getIdPhoto())){
            return new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "File deleted");
        }
        else{
            return new ResultOperationDtoResponse(RequestCode.OPERATION_ERROR, "File dont deleted");
        }
    }

    @Override
    public ResultOperationDtoResponse addCategoriesInProfile(AddCategoriesDtoRequest acdr) {
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlAddCatInProfile)) {
            statement.setInt(1, acdr.getIdCategories());
            statement.setInt(2, acdr.getIdPhotographer());
            statement.execute();
            return new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "Категория добавлена");

        } catch (SQLException e) {
            return new ResultOperationDtoResponse(RequestCode.ERROR_DATA_BASE, "Ошибка сервера");
        }
    }

    @Override
    public ResultOperationDtoResponse deleteGatFromProfile(DeleteCategoriesDtoRequest dcdr) {
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlDeleteCatFromProfile)) {
            statement.setInt(1,  dcdr.getIdPhotographer());
            statement.setInt(2, dcdr.getIdCat());
            statement.execute();
            return new ResultOperationDtoResponse(RequestCode.OPERATION_SUCCESSFUL, "Category add");
        } catch (SQLException e) {
            return new ResultOperationDtoResponse(RequestCode.ERROR_DATA_BASE, "Error server");
        }

    }

    @Override
    public ResultOperationDtoResponse getAllCategoriesForPhotographer(CategoriesDtoResponse cdr) {
        return null;
    }

    public PhotographersListDtoResponse getListPhotographerByCat(PhotographersListDtoRequest pldr) {

        List<Photographer> photographers = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlGetLimitPhotographersByCat)){
            statement.setInt(1,pldr.getIdCat());
            statement.setInt(2,pldr.getIndexLastPhotographer());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Photographer photographer = new Photographer();
                photographer.setId(resultSet.getInt(1));
                photographer.setFirstName(resultSet.getNString(2));
                photographer.setLastName(resultSet.getNString(3));
                photographer.setPriceForHour(resultSet.getInt(4));
                photographer.setPriceForProject(resultSet.getInt(5));
                photographers.add(photographer);
            }
            return new PhotographersListDtoResponse(photographers, "Good");

        } catch (SQLException e) {
            return new PhotographersListDtoResponse(photographers, "Error BD");
        }
    }


    public FullProfilePhotographerDtoResponse getFullProfile(FullProfilePhotographerDtoRequest fprdr) {
        String[] images;
        FullProfilePhotographerDtoResponse fullProfile = new FullProfilePhotographerDtoResponse();
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlGetFullProfile)){
            statement.setInt(1,fprdr.getIdPhotographer());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                fullProfile.setFirstName(resultSet.getNString(1));
                fullProfile.setLastName(resultSet.getNString(2));
                fullProfile.setEmail(resultSet.getNString(3));
                fullProfile.setAbout(resultSet.getNString(4));
                fullProfile.setPriceForHour(resultSet.getInt(5));
                fullProfile.setPriceForProject(resultSet.getInt(6));
            }

            images = FolderPhotos.getPhotosByPhotographer(fprdr.getIdPhotographer());
            fullProfile.setImageStringBase64(images);
            return fullProfile;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public CategoriesDtoResponse getAllCat() {

        List<Category> categories = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SqlString.sqlGetAllCat)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                categories.add(new Category(resultSet.getInt(1), resultSet.getString(2)));
            }
            return new CategoriesDtoResponse(categories, RequestCode.OPERATION_SUCCESSFUL);
        } catch (SQLException e) {
            return new CategoriesDtoResponse(null, RequestCode.OPERATION_ERROR);
        }
    }

}
