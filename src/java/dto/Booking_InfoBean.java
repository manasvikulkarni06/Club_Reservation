
package dto;


public class Booking_InfoBean implements java.io.Serializable{
    private String booking_id;
    private String userid;
    private String slot_id;
    private String court_id;
    private String booking_date_time;
    private String reservation_date_time;
    private boolean booking_status;

    public Booking_InfoBean() {
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(String slot_id) {
        this.slot_id = slot_id;
    }

    public String getCourt_id() {
        return court_id;
    }

    public void setCourt_id(String court_id) {
        this.court_id = court_id;
    }

    public String getBooking_date_time() {
        return booking_date_time;
    }

    public void setBooking_date_time(String booking_date_time) {
        this.booking_date_time = booking_date_time;
    }

    public String getReservation_date_time() {
        return reservation_date_time;
    }

    public void setReservation_date_time(String reservation_date_time) {
        this.reservation_date_time = reservation_date_time;
    }

    public boolean isBooking_status() {
        return booking_status;
    }

    public void setBooking_status(boolean booking_status) {
        this.booking_status = booking_status;
    }
    
    
}
