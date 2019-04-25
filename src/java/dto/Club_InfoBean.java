
package dto;


public class Club_InfoBean implements java.io.Serializable{
    private String club_id;
    private String club_name;
    private String opening_time;
    private String closing_time;
    private int no_of_courts;
    private boolean visibility;

    public Club_InfoBean() {
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public int getNo_of_courts() {
        return no_of_courts;
    }

    public void setNo_of_courts(int no_of_courts) {
        this.no_of_courts = no_of_courts;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
    
}
