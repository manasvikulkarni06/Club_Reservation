
package dto;


public class Club_MemberBean implements java.io.Serializable{
    private String userid;
    private String password;
    private String member_name;
    private String contact_no;
    private String club_id;

    public Club_MemberBean() {
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getContact_no() {
        return contact_no;
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

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }
    
    
}
