package DAO;

import DTO.DTOrequest.FullProfilePhotographerDtoRequest;
import DTO.DTOrequest.PhotographersListDtoRequest;
import DTO.DTOresponse.CategoriesDtoResponse;
import DTO.DTOresponse.FullPhotoByPhotographerDtoResponse;
import DTO.DTOresponse.FullProfilePhotographerDtoResponse;
import DTO.DTOresponse.PhotographersListDtoResponse;

public interface UserDao {
    PhotographersListDtoResponse getListPhotographerByCat(PhotographersListDtoRequest pldr);
    FullProfilePhotographerDtoResponse getFullProfile(FullProfilePhotographerDtoRequest fprdr);

    CategoriesDtoResponse getAllCat();
}
