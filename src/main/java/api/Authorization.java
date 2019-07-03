package api;

import DTO.DTOrequest.AuthorizationPhotographerDtoRequest;
import com.google.gson.Gson;
import service.IServiceRespone;
import service.Service;
import service.ServiceRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Authorization", urlPatterns = {"/Authorization"})
public class Authorization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        String json = new ServiceRequest().getJsonFromRequest(request);
        try {
            new ServiceRequest().writeJsonToResponse(response, new Service().authorization(json));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
