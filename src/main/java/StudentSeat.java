
public class StudentSeat {
    private String c_name;
    private String cour_name;
    int college_id;
    private int filled_seats;
    private int remaining_seats;
    private int total_seats;
    int cour_id;
   

    
    public int getCour_id() {
        return cour_id;
    }
    public void setCour_id(int cour_id) {
        this.cour_id = cour_id;
    }
    public StudentSeat(String c_name, String cour_name, int college_id, int filled_seats, int remaining_seats,
            int total_seats) {
        this.c_name = c_name;
        this.cour_name = cour_name;
        this.college_id = college_id;
        this.filled_seats = filled_seats;
        this.remaining_seats = remaining_seats;
        this.total_seats = total_seats;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getCour_name() {
        return cour_name;
    }
    public void setCour_name(String cour_name) {
        this.cour_name = cour_name;
    }
    public int getCollege_id() {
        return college_id;
    }
    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }
    public int getFilled_seats() {
        return filled_seats;
    }
    public void setFilled_seats(int filled_seats) {
        this.filled_seats = filled_seats;
    }
    public int getRemaining_seats() {
        return remaining_seats;
    }
    public void setRemaining_seats(int remaining_seats) {
        this.remaining_seats = remaining_seats;
    }
    public int getTotal_seats() {
        return total_seats;
    }
    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }
  

    
}
