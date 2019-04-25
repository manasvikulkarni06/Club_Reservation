
package dao;

import com.google.gson.Gson;
import dbcon.MydbConnection;
import dto.Slot_InfoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


public class Slot_InfoDAO {
 
    
     public int insertslot(Slot_InfoBean ob)
     {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
        
        String slot_id=ob.getSlot_id();
        String stime=ob.getStart_time();
        String etime=ob.getEnd_time();
        String cid=ob.getCourt_id();
       
        
        
        PreparedStatement pst=con.prepareStatement("insert into slot_info"+"values(?,?,?,?)");
       
        pst.setString(1,slot_id);
        pst.setString(2,stime);
        pst.setString(3,etime);
        pst.setString(4,cid);
             
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }

     public String showAllSlots()
    {
        String result = "";
        ArrayList<Slot_InfoBean> slotlist = new ArrayList<>();
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from slot_info");
             
           ResultSet rs = pst.executeQuery();
           
           while(rs.next())
           {
               Slot_InfoBean ob = new Slot_InfoBean();
               
               ob.setSlot_id(rs.getString("slot_id"));
               ob.setStart_time(""+rs.getTime("start_time"));
               ob.setEnd_time(""+rs.getTime("end_time"));
               ob.setCourt_id(rs.getString("court_id"));
               
               
               slotlist.add(ob);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Gson g = new Gson();
        
        result = g.toJson(slotlist);
        
        return result;
    }
     public int deleteSlot(String sid)
    { 
        int count=0;
        
         try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("delete from slot_info where slot_id = ?");
        
             pst.setString(1, sid);
             
             count = pst.executeUpdate();
        }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
         return count;
    }
     public int updateSlot(Slot_InfoBean ob)
    {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
          
       
        String courtid=ob.getCourt_id();
        String sid=ob.getSlot_id();
        String stime=ob.getStart_time();
        String etime=ob.getEnd_time();
        
        PreparedStatement pst=con.prepareStatement("update slot_info"+"set start_time=?,end_time=?,where slot_id=?");
  
        pst.setString(1,stime);
        pst.setString(2,etime);
        pst.setString(3,sid);
       
       
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
     public String searchSlot(String sid)
    {
        String result = "";
         Slot_InfoBean ob=null;
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from slot_info where slot_id=?");
             
             pst.setString(1,sid);
             
           ResultSet rs = pst.executeQuery();
           
          
                   
           if(rs.next())
           {
               ob = new Slot_InfoBean();
               
               ob.setCourt_id(rs.getString("court_id"));
               ob.setSlot_id(rs.getString("slot_id"));
               ob.setStart_time(""+rs.getTime("start_time"));
               ob.setEnd_time(""+rs.getTime("end_time"));
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
