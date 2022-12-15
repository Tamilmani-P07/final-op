import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("/status")
public class StatusServlet extends HttpServlet{

    AppDao ad;
    List<Allotment> status;

    Gson g =new Gson();
    @Override
    public void init() throws ServletException {
        String url="jdbc:mysql://localhost:3306/admission?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user="root";
        String pass="";
        ad=new AppDao(url, user, pass);
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        status=new ArrayList<Allotment>();
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Signup statuslist = g.fromJson(requestData, Signup.class);
        String un=statuslist.getName();
        String pass=statuslist.getPass();
        //System.out.println(un);
        try {
            status= ad.getStatus(un,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            Gson g= new Gson();
            String statusString=g.toJson(status);
            resp.getWriter().println(statusString);
    }

    
}
