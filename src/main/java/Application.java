public class Application {
    private int application_id;
    private String student_name;
    private int student_mark;
    private String location_name;
    public int getApplication_id() {
        return application_id;
    }
    public Application(int application_id, String student_name, int student_mark, String location_name) {
        this.application_id = application_id;
        this.student_name = student_name;
        this.student_mark = student_mark;
        this.location_name = location_name;
    }
    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }
    public Application( String student_name,int application_id) {
        
        this.student_name = student_name;
        this.application_id = application_id;
    }
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public int getStudent_mark() {
        return student_mark;
    }
    public void setStudent_mark(int student_mark) {
        this.student_mark = student_mark;
    }
    public String getLocation_name() {
        return location_name;
    }
    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
    
  
    
}
