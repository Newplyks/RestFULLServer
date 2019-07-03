package api;

import service.Service;
import service.ServiceRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddPhotosInProfile", urlPatterns = {"/AddPhotoInProfile"})
public class AddPhotosInProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = new ServiceRequest().getJsonFromRequest(request);
        try {
            String jsonResponse = new Service().addPhotoInProfile(json);
            new ServiceRequest().writeJsonToResponse(response,jsonResponse);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
