public class Allotment {
    String studentName;
    int  allotmentId;
    int applicationId;
    String collegeName;
    String courseName;
    int courseId;
    int student_id;
    String status;
     public Allotment(int applicationId, String studentName,int allotmentId, String status){
        this.applicationId = applicationId;
        this.studentName = studentName; 
        this.allotmentId = allotmentId;
        this.status = status;
     }
    public Allotment(int courseId,String courseName) {
        this.courseName = courseName;
        this.courseId = courseId;
    }
    public Allotment(String studentName, int allotmentId, int applicationId, String collegeName, String courseName) {
        this.studentName = studentName;
        this.allotmentId = allotmentId;
        this.applicationId = applicationId;
        this.collegeName = collegeName;
        this.courseName = courseName;
    }
    public Allotment(int studentId, String studentName2, String status2) {
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getAllotmentId() {
        return allotmentId;
    }
    public void setAllotmentId(int allotmentId) {
        this.allotmentId = allotmentId;
    }
    public int getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    

    
    
    
}
