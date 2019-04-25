
package dao;

import com.google.gson.Gson;
import dbcon.MydbConnection;
import dto.Club_InfoBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Club_InfoDAO {
  
     public int insertClub(Club_InfoBean ob,String userid)
     {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
          String pass= UUID.randomUUID().toString().substring(0,8);
       
       
        String cid=null;
        String cname=ob.getClub_name();
        Time openingTime=Time.valueOf(ob.getOpening_time());
        Time closingTime=Time.valueOf(ob.getClosing_time());
        int  no_Of_Courts=ob.getNo_of_courts();
        boolean visibility=true;
        
        
        PreparedStatement pst1=con.prepareStatement("Select club_id from club_owner where userid=? ");
        pst1.setString(1,userid);
        ResultSet rs=pst1.executeQuery();
        while(rs.next())
        {
            cid=rs.getString("club_id");
            
        }
        PreparedStatement pst=con.prepareStatement("insert into club_info"+" values(?,?,?,?,?,?)");
       
        pst.setString(1,cid);
        pst.setString(2,cname);
        pst.setTime(3,openingTime);
        pst.setTime(4,closingTime);
        pst.setInt(5,no_Of_Courts);
        pst.setBoolean(6, visibility);
        
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
    public int updateClub(Club_InfoBean ob)
    {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
          String pass= UUID.randomUUID().toString().substring(0,8);
       
       
        String cid=ob.getClub_id();
        String cname=ob.getClub_name();
        String openingTime=ob.getOpening_time();
        String closingTime=ob.getClosing_time();
        int  no_Of_Courts=ob.getNo_of_courts();
        boolean visibility=ob.isVisibility();
        
        PreparedStatement pst=con.prepareStatement("update club_info"+"set club_name=?,opening_time=?,closing_time=?,no_of_courts=?,visibility=?,where club_id=?");
        
       
        
        pst.setString(1,cname);
        pst.setString(2,openingTime);
        pst.setString(3,closingTime);
        pst.setInt(4,no_Of_Courts);
        pst.setBoolean(5, visibility);
        pst.setString(6, cid);
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     } 
    
    
    public String showAllClubs()
    {
        String result = "";
        ArrayList<Club_InfoBean> clublist = new ArrayList<>();
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from club_info");
             
           ResultSet rs = pst.executeQuery();
           
           while(rs.next())
           {
               Club_InfoBean ob = new Club_InfoBean();
               
               ob.setClub_id(rs.getString("club_id"));
               ob.setClub_name(rs.getString("club_name"));
               ob.setOpening_time(""+rs.getTime("opening_time"));
               ob.setClosing_time(""+rs.getTime("closing_time"));
               ob.setNo_of_courts(rs.getInt("no_of_courts"));
               ob.setVisibility(rs.getBoolean("visibility"));
               
               clublist.add(ob);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Gson g = new Gson();
        
        result = g.toJson(clublist);
        
        return result;
    }
    
    
    
    public String searchClub(String cid)
    {
        String result = "";
         Club_InfoBean ob=null;
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from club_info where club_id=?");
             
             pst.setString(1,cid);
             
           ResultSet rs = pst.executeQuery();
           
          
                   
           if(rs.next())
           {
               ob = new Club_InfoBean();
               
               ob.setClub_id(rs.getString("club_id"));
               ob.setClub_name(rs.getString("club_name"));
               ob.setOpening_time(""+rs.getTime("opening_time"));
               ob.setClosing_time(""+rs.getTime("closing_time"));
               ob.setNo_of_courts(rs.getInt("no_of_courts"));
               ob.setVisibility(rs.getBoolean("visibility"));
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

