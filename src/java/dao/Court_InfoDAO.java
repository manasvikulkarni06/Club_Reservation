
package dao;

import com.google.gson.Gson;
import dbcon.MydbConnection;
import dto.Court_InfoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


public class Court_InfoDAO {
     public int insertCourt(Court_InfoBean ob)
     {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
        String cid=ob.getClub_id();
        String court_id=ob.getCourt_id();
        String cname=ob.getCourt_name();
        String type=ob.getType();
        boolean visibility=ob.isVisibility();
        
        
        PreparedStatement pst=con.prepareStatement("insert into court_info"+"values(?,?,?,?,?)");
       
        pst.setString(1,cid);
        pst.setString(2,cname);
        pst.setString(3,court_id);
        pst.setString(4,type);
        pst.setBoolean(5, visibility);
        
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
     public String showAllCourts()
    {
        String result = "";
        ArrayList<Court_InfoBean> courtlist = new ArrayList<>();
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from court_info");
             
           ResultSet rs = pst.executeQuery();
           
           while(rs.next())
           {
               Court_InfoBean ob = new Court_InfoBean();
               
               ob.setClub_id(rs.getString("club_id"));
               ob.setCourt_name(rs.getString("court_name"));
               ob.setType(rs.getString("type"));
               ob.setCourt_id(rs.getString("court_id"));
               ob.setVisibility(rs.getBoolean("visibility"));
               
               courtlist.add(ob);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Gson g = new Gson();
        
        result = g.toJson(courtlist);
        
        return result;
    }
    
     public String searchCourt(String court_id)
    {
        String result = "";
         Court_InfoBean ob=null;
        
        try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("select * from court_info where court_id=?");
             
             pst.setString(1,court_id);
             
           ResultSet rs = pst.executeQuery();
           
          
                   
           if(rs.next())
           {
               ob = new Court_InfoBean();
               
               ob.setCourt_id(rs.getString("court_id"));
               ob.setCourt_name(rs.getString("court_name"));
               ob.setClub_id(rs.getString("club_id"));
               ob.setType(rs.getString("type"));
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

       public int updateCourt(Court_InfoBean ob)
    {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
          
       
        String courtid=ob.getCourt_id();
        String cid=ob.getClub_id();
        String cname=ob.getCourt_name();
        String type=ob.getType();
        boolean visibility=ob.isVisibility();
        
        PreparedStatement pst=con.prepareStatement("update court_info"+"set court_name=?,type=?,visibility=?,where court_id=?");
        
       
        
        pst.setString(1,cname);
        pst.setString(2,type);
        pst.setBoolean(3,visibility);
        pst.setString(4,courtid);
       
       
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     } 
       public int deleteCourt(String cid)
    {
        int count=0;
        
         try
        {
             Connection con = 
         MydbConnection.getDbConnection();
             
             PreparedStatement pst = 
        con.prepareStatement("delete from court_info where court_id = ?");
        
             pst.setString(1, cid);
             
             count = pst.executeUpdate();
        }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
         return count;
    }
  
   }
   

