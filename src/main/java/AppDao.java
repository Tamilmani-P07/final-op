import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppDao {
    String url;
    String user;
    String pass;
    Connection con;

    public AppDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public void connect() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(url, user, pass);
        }
    }

    public void disconnect() throws SQLException {
        if (con != null || !con.isClosed()) {
            con.close();
        }

    }

    public List<Application> applicationDao() throws SQLException {
        List<Application> la;
        String qry = "SELECT A.A_ID AS 'APPLICATION ID',S.S_NAME AS 'SATUDENT NAME',S.S_MARK AS 'STUDENT MARK',L.LOCATION_NAME AS 'LOCATION NAME' FROM application A JOIN student S ON  A.S_ID=S.S_ID JOIN location L ON S.LOCATION_ID=L.LOCATION_ID";
        la = new ArrayList<Application>();
        connect();
        PreparedStatement pstmt = con.prepareStatement(qry);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int application_id = rs.getInt(1);
            String student_name = rs.getString(2);
            int student_mark = rs.getInt(3);
            String location_name = rs.getString(4);
            la.add(new Application(application_id, student_name, student_mark, location_name));
            System.out.println(application_id + " " + student_name + " " + student_mark + " " + location_name);
        }
        rs.close();
        pstmt.close();
        disconnect();
        return la;

    }

    public List<Allotment> allotmentDao() throws SQLException {
        List<Allotment> al = new ArrayList<Allotment>();

        String qrey = "SELECT S.s_name AS 'SELECTED STUDENT',AL.ALLOTMENT_ID AS'ALLOTMENT ID',A.A_ID AS 'APPLICATION ID',c.C_NAME AS'COLLEGE NAME',CO.COUR_NAME AS'COURSE NAME' FROM student S   JOIN application A ON S.S_ID=A.S_ID JOIN allotment AL ON  A.A_ID=AL.A_ID join course_selection cs ON cs.CS_ID=AL.CS_ID JOIN course CO ON cs.COURSE_ID=CO.COURSE_ID JOIN college c  ON c.C_ID=cs.C_ID WHERE AL.A_ID= A.A_ID";
        connect();
        PreparedStatement pstmt = con.prepareStatement(qrey);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {

            String student_name = rs.getString(1);
            int allotmentId = rs.getInt(2);
            int application_id = rs.getInt(3);
            String collegeName = rs.getString(4);
            String courseName = rs.getString(5);

            al.add(new Allotment(student_name, allotmentId, application_id, collegeName, courseName));
            System.out.println(
                    student_name + " " + allotmentId + " " + application_id + " " + collegeName + " " + courseName);
        }
        rs.close();
        pstmt.close();
        disconnect();
        return al;

    }

    public List<StudentSeat> getStudentSeatList(int co_id, int c_id) throws SQLException {
        String qry = "SELECT C_NAME AS 'COLLEGE NAME',c.cour_name AS 'COURSE NAME',co.C_ID AS 'COLLEGE ID',COUNT(cs.C_ID) AS 'FILLED SEATS',c.total_seats-COUNT(cs.C_ID)AS 'REMAINING SEATS',(c.total_seats)AS 'TOTAL SEATS'  FROM course c  JOIN course_selection cs  ON c.COURSE_ID=cs.COURSE_ID JOIN college co  ON cs.C_ID=co.C_ID WHERE co.C_ID=? AND c.COURSE_ID=?";
        List<StudentSeat> ls=new ArrayList<StudentSeat>();
        connect();
        PreparedStatement pstmt = con.prepareStatement(qry);
        pstmt.setInt(1, co_id);
        pstmt.setInt(2, c_id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String c_name=rs.getString(1);
            String cour_name=rs.getString(2);
            int college_id=rs.getInt(3);
            int filled_seats=rs.getInt(4);
            int remaining_seats=rs.getInt(5);
            int total_seats=rs.getInt(6);
            ls.add(new StudentSeat(c_name, cour_name, college_id, filled_seats, remaining_seats, total_seats));
            System.out.println(c_name+" "+cour_name +" "+college_id+" "+ filled_seats+" "+ remaining_seats+" "+ total_seats);
        }
        rs.close();
        pstmt.close();
        disconnect();
        return ls;

    }

    public List<Allotment> getStatus(String un, String pass) throws SQLException {
       // System.out.println("getstatus");
        String qry = "SELECT a.a_id ,s.S_NAME  ,al.ALLOTMENT_ID  FROM login l  join   student s ON l.id=s.id JOIN application a ON  s.S_ID=a.S_ID  join allotment al  ON a.A_ID=al.A_ID  WHERE s.s_name=? AND l.pass=?";
        List<Allotment> ls=new ArrayList<Allotment>();
        connect();
        PreparedStatement pstmt = con.prepareStatement(qry);
         System.out.println(un);
         System.out.println(pass);
        pstmt.setString(1, un);
        pstmt.setString(2, pass);
        
        ResultSet rs = pstmt.executeQuery();
         //System.out.println(rs.next());
         if (rs.next()) {
            int applicationId=rs.getInt(1);
            String studentName=rs.getString(2);
            int allotmentId=rs.getInt(3);
            String status="Alloted";

            ls.add(new Allotment( applicationId,  studentName, allotmentId ,status));
          // System.out.println(applicationId+" "+ studentName+" "+ allotmentId );
          } else {
             String qry1="SELECT a.a_id,s.S_NAME  FROM login l  join   student s ON l.id=s.id JOIN application a ON  s.S_ID=a.S_ID   WHERE s.s_name=? AND l.pass=?";
             pstmt = con.prepareStatement(qry1);
             pstmt.setString(1, un);
             pstmt.setString(2, pass);
             rs = pstmt.executeQuery();
             if (rs.next()) {
                 int applicationId=rs.getInt(1);
                 String studentName=rs.getString(2);
                 int allotmentId=0;
                 String status="Not Alloted";
                 ls.add(new Allotment( applicationId,studentName,allotmentId,status));
                 //System.out.println(applicationId+" "+ studentName+" "+ status );
             }
            
          }
        rs.close();
        pstmt.close();
        disconnect();
        return ls;

    }

  

    public int signup(String name, String pass, String category) throws SQLException {

        int s=0;
        String qry="SELECT * FROM login WHERE u_name=?";
        connect();
        PreparedStatement pstmt = con.prepareStatement(qry);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
         s=-1;
         rs.close();

        }
        else{
        String qry1 = "INSERT INTO tempsignup (u_name,pass,category) VALUES (?,?,?)";
        pstmt = con.prepareStatement(qry1);
        pstmt.setString(1,name);
        pstmt.setString(2,pass);
        pstmt.setString(3,category);
        s=pstmt.executeUpdate();
        System.out.println("sd");
        }
          pstmt.close();
          disconnect();
        return s;

    }

    public String checkUser(String email, String pass2) throws SQLException {
        String s = "INVALID";
        connect();
        PreparedStatement ps = con.prepareStatement("select category from login where u_name=? and pass=?");
        ps.setString(1, email);
        ps.setString(2, pass2);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            s = rs.getString(1);
            rs.close();
            ps.close();
            disconnect();
            return s;
        }
        else{
            rs.close();
            ps.close();
            disconnect();
            return s;
        }

    }

    public List<Application> rejectedDao() throws SQLException {
        List<Application> al = new ArrayList<Application>();

        String qrey = "SELECT a.a_id,s.S_NAME FROM application a join student s ON a.s_id=s.s_id WHERE a_id NOT IN (SELECT a_id FROM allotment);";
        connect();
        PreparedStatement pstmt = con.prepareStatement(qrey);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            String student_name = rs.getString(2);
            
            int application_id = rs.getInt(1);

            al.add(new Application(student_name, application_id));
            System.out.println(application_id + " " + student_name);
        }
        rs.close();
        pstmt.close();
        disconnect();
        return al;
    }

    public List<Allotment> departDao() throws SQLException {
        List<Allotment> al = new ArrayList<Allotment>();

        String qrey = "SELECT course_id,cour_name FROM course";
        connect();
        PreparedStatement pstmt = con.prepareStatement(qrey);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            String courseName = rs.getString(2);
            
            int courseId = rs.getInt(1);

            al.add(new Allotment(courseId,courseName));
            System.out.println(courseId + " " + courseName);
        }
        rs.close();
        pstmt.close();
        disconnect();
        return al;
    

}

    public ArrayList<Signup> approval() throws SQLException {
        ArrayList<Signup> al = new ArrayList<Signup>();
        String qry="select * from tempsignup";
        connect();
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery(qry);
       
        while(rs.next()){
            String name=rs.getString(1);
            String category=rs.getString(2);
            System.out.println(name);
            System.out.println(category);
           al.add(new Signup(name,category)) ;
        }
        if(al.isEmpty()){
            al.add(new Signup("Nill","Nill")) ;
        }
        System.out.println(al);
        
        rs.close();
        stmt.close();
        disconnect();
        return al;
    }

    public String acceptApproval(String name) throws SQLException {
    
        Signup si=null;
        String qry="select * from tempsignup where u_name=?";
        connect();
        PreparedStatement pstmt=con.prepareStatement(qry);
        pstmt.setString(1,name);
        ResultSet rs = pstmt.executeQuery();
       
        while(rs.next()){
            String n=rs.getString(1);
            String category=rs.getString(2);
            String pass=rs.getString(4);
           si=new Signup(n,category,pass);
        }

        String qry1 = "INSERT INTO login (u_name,pass,category) VALUES (?,?,?)";
        pstmt = con.prepareStatement(qry1);
        pstmt.setString(1,si.getName());
        pstmt.setString(2,si.getPass());
        pstmt.setString(3,si.getCategory());
        pstmt.executeUpdate();

        rs.close();
        pstmt.close();
        disconnect();
        
        System.out.println(deleteApproval(name));
      return "Approval Accepted";
    }
    public int deleteApproval(String name) throws SQLException{
        String q="DELETE FROM tempsignup WHERE u_name=?";
        connect();
        PreparedStatement pstmt = con.prepareStatement(q);
        pstmt.setString(1,name);
        int i=pstmt.executeUpdate();
        
        pstmt.close();
        disconnect();
        return i;
    }

}
