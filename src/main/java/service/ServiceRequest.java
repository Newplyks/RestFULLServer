package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServiceRequest implements IServiceRequest, IServiceRespone {
    @Override
    public String getJsonFromRequest(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s=request.getReader().readLine())!=null){
            sb.append(s);
        }
        request.getReader().close();
        return sb.toString();
    }

    @Override
    public void writeJsonToResponse(HttpServletResponse response, String json) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();
    }
}
