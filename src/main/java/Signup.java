public class Signup {
    String name;
    String  pass;
    String category;
    String action;
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Signup(String name, String pass, String category) {
        this.name = name;
        this.pass = pass;
        this.category = category;
    }
   
    public Signup(String name2, String category2) {
        this.name=name2;
        this.category = category2;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getcategory() {
        return category;
    }
    public void setcategory(String category) {
        this.category = category;
    }
    
}
