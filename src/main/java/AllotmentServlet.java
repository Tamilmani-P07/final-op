import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/allotment")
public class AllotmentServlet extends HttpServlet{
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
            List<Allotment> allo=ad.allotmentDao();
            Gson g= new Gson();
            String alloString=g.toJson(allo);
            resp.getWriter().println(alloString);
            
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("fgnghj");
    
        try {
            List<Application> reje = ad.rejectedDao();
            Gson g= new Gson();
        String rejeString=g.toJson(reje);
        resp.getWriter().println(rejeString);
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
       
    }
    
    
}