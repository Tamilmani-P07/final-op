import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * CollrgeLogin
 */
@WebServlet("/login")
public class CollegeLogin extends HttpServlet {
    AppDao ad;
    

    @Override
    public void init() throws ServletException {
        String url = "jdbc:mysql://localhost:3306/admission?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        ad = new AppDao(url, user, pass);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("post");
        Gson g = new Gson();
        String requestData = request.getReader().lines().collect(Collectors.joining());
        Signup statuslist = g.fromJson(requestData, Signup.class);
        String name = statuslist.getName();
        String pass = statuslist.getPass();
        System.out.println(name);
        String j;
        try {
            j = ad.checkUser(name, pass);
            String category = j;
            ArrayList<Signup> al = new ArrayList<Signup>();
            al.add(new Signup(name, pass, category));
            String logString = g.toJson(al);
            System.out.println(logString);
            response.getWriter().println(logString);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put");

        String requestData = req.getReader().lines().collect(Collectors.joining());
        Gson g = new Gson();
        Signup statuslist = g.fromJson(requestData, Signup.class);
        System.out.println(statuslist.getName());
        try {
            int s = ad.signup(statuslist.getName(), statuslist.getPass(), statuslist.getcategory());
            System.out.println(s);
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(s);
            
            String signup = g.toJson(al);
            System.out.println(signup);
            resp.getWriter().println(signup);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Signup> al = new ArrayList<Signup>();
        Gson g = new Gson();
        try {
            al = ad.approval();
            String approve = g.toJson(al);
            System.out.println(approve);
            resp.getWriter().println(approve);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Gson g = new Gson();
        Signup s = g.fromJson(requestData, Signup.class);
        String name=s.getName();
        String action =s.getAction();
        if (action.equals("Accept")) {
            try {
                String si=ad.acceptApproval(name);
                System.out.println(si);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                System.out.println(ad.deleteApproval(name));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
