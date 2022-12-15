import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet(urlPatterns = "/app")
public class Appservlet extends HttpServlet{
    AppDao ad;
    
    @Override
    public void init() throws ServletException {
        String url="jdbc:mysql://localhost:3306/admission?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user="root";
        String pass="";
        ad=new AppDao(url, user, pass);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Application> allo=ad.applicationDao();
            Gson g= new Gson();
            String alloString=g.toJson(allo);
            resp.getWriter().println(alloString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fgnghj");
    
        try {
            List<Allotment> reje = ad.departDao();
            Gson g= new Gson();
        String departString=g.toJson(reje);
        resp.getWriter().println(departString);
        } catch (SQLException e) {
        
            e.printStackTrace();
        } 
}
   
    

    
}
