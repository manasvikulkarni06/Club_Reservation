
package dto;


public class Club_OwnerBean implements java.io.Serializable{
    private String userid;
    private String password;
    private String contact_no;
    private String owner_name;
    private String club_id;

    public Club_OwnerBean() {
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }
    
    
}
