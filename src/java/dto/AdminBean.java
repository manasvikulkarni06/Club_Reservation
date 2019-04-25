
package dto;

public class AdminBean implements java.io.Serializable{
    
    private String userid;
    private String password;

    public AdminBean() {
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
