import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {

    public static String checkUser(String email, String pass) {
        String s = null;
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/admission?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "");
            PreparedStatement ps = con.prepareStatement("select category from login where u_name=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = rs.getString(1);

                return s;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}
