
package dao;

import com.google.gson.Gson;
import dbcon.MydbConnection;
import dto.Booking_InfoBean;
import dto.Slot_InfoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


public class Booking_InfoDAO {
    public int insertBooking(Booking_InfoBean ob)
     {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
        
        String booking_id=ob.getBooking_id();
        String userid=ob.getUserid();
        String slot_id=ob.getSlot_id();
        String court_id=ob.getCourt_id();
        String booking_date_time=ob.getBooking_date_time();
        String reservation_date_time=ob.getReservation_date_time();
        Boolean booking_status=ob.isBooking_status();
        
        
        PreparedStatement pst=con.prepareStatement("insert into booking_info"+"values(?,?,?,?,?,?,?)");
       
        pst.setString(1,booking_id);
        pst.setString(2,userid);
        pst.setString(3,slot_id);
        pst.setString(4,court_id);
        pst.setString(5,booking_date_time);
        pst.setString(6,reservation_date_time);
        pst.setBoolean(7,booking_status);
             
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
    public String showAllBookings()
    {
        String result = "";
        ArrayList<Booking_InfoBean> Bookinglist = new ArrayList<>();
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from Booking_info");
             
           ResultSet rs = pst.executeQuery();
           
           while(rs.next())
           {
               Booking_InfoBean ob = new Booking_InfoBean();
      
               ob.setBooking_id(rs.getString("booking_id"));
               ob.setUserid(rs.getString("userid"));
               ob.setBooking_date_time(""+rs.getTime("booking_date_time"));
               ob.setReservation_date_time(""+rs.getTime("reservation_date_time"));
               ob.setSlot_id(rs.getString("slot_id"));
               ob.setCourt_id(rs.getString("court_id"));
               ob.setBooking_status(rs.getBoolean("booking_status"));
               
               Bookinglist.add(ob);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Gson g = new Gson();
        
        result = g.toJson(Bookinglist);
        
        return result;
    }
    
    public int updateBooking(Booking_InfoBean ob)
    {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
          
       
        String booking_id=ob.getBooking_id();
        String userid=ob.getUserid();
        String slot_id=ob.getSlot_id();
        String court_id=ob.getCourt_id();
        String booking_date_time=ob.getBooking_date_time();
        String reservation_date_time=ob.getReservation_date_time();
        Boolean booking_status=ob.isBooking_status();

        
        PreparedStatement pst=con.prepareStatement("update booking_info"+"set booking_date_time=?,reservation_date_time=?,booking_status=?,where booking_id=?");
  
        pst.setString(1,booking_date_time);
        pst.setString(2,reservation_date_time);
        pst.setBoolean(3,booking_status);
        pst.setString(4,booking_id);
      
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
    public String searchBooking(String bid)
    {
        String result = "";
         Booking_InfoBean ob=null;
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from booking_info where booking_id=?");
             
             pst.setString(1,bid);
             
           ResultSet rs = pst.executeQuery();
           
          
                   
           if(rs.next())
           {
               ob = new Booking_InfoBean();
               ob.setBooking_id(rs.getString("booking_id"));
               ob.setUserid(rs.getString("userid"));
               ob.setBooking_date_time(""+rs.getTime("booking_date_time"));
               ob.setReservation_date_time(""+rs.getTime("reservation_date_time"));
               ob.setSlot_id(rs.getString("slot_id"));
               ob.setCourt_id(rs.getString("court_id"));
               ob.setBooking_status(rs.getBoolean("booking_status"));
           }
           else
           {
               HashMap<String,String> mymap = new HashMap<>();
               mymap.put("result","-ve");
               
               Gson gs = new Gson();
          
               String res = gs.toJson(mymap);
               
               return res;
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Gson g = new Gson();
        
        result = g.toJson(ob);
        
        return result;
    }
    
}
