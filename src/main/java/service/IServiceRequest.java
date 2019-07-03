package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IServiceRequest {

    String getJsonFromRequest(HttpServletRequest request) throws IOException;
    void writeJsonToResponse(HttpServletResponse response, String Json) throws IOException;
}
