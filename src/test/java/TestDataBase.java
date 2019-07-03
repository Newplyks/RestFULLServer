import DTO.DTOrequest.RegistratonPhotogrpherDtoReauest;
import DTO.DTOresponse.RegistrationPhotographerDTOresponse;
import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import service.Service;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataBase {

    @Test
    public void Reg() throws SQLException, IOException, ClassNotFoundException {
        Service service = new Service();
        RegistratonPhotogrpherDtoReauest registratonPhotogrpherDtoReauest = new RegistratonPhotogrpherDtoReauest(
                "Ваня", "Пукииии2222н", "goooog.cooom", "qweqwe");


        String saa = service.registration(new Gson().toJson(registratonPhotogrpherDtoReauest));
        RegistrationPhotographerDTOresponse registrationPhotographerDtoResponse = new Gson().fromJson(
                saa, RegistrationPhotographerDTOresponse.class);
        assertNotNull(registrationPhotographerDtoResponse);


    }
}
