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
@WebServlet("/seats")
public class StudentSeatServlet extends HttpServlet{
    AppDao ad;

    Gson g =new Gson();
    @Override
    public void init() throws ServletException {
        String url="jdbc:mysql://localhost:3306/admission?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user="root";
        String pass="";
        ad=new AppDao(url, user, pass);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentSeat> ls=new ArrayList<StudentSeat>();
        String requestData = req.getReader().lines().collect(Collectors.joining());
        
        StudentSeat seatlist=g.fromJson(requestData, StudentSeat.class);
          System.out.println(seatlist.college_id+" "+seatlist.cour_id);
        try {
            ls=ad.getStudentSeatList(seatlist.college_id,seatlist.cour_id);
            // if (condition) {
                
            // } else {
                
            // }
            System.out.println(ls);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String StuSeString=g.toJson(ls);
        resp.getWriter().print(StuSeString);
    }
}
