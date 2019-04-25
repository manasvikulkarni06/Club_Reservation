
package dao;

import dbcon.MydbConnection;
import dto.Club_MemberBean;
import dto.Club_OwnerBean;
import java.sql.*;
import java.util.UUID;

public class Club_OwnerDAO {
     public boolean isUserValid(Club_OwnerBean ob)
 {  boolean b=false;
     System.out.println(ob.getUserid()); 
    try
     {
         Connection con=MydbConnection.getDbConnection();
         
         String uid=ob.getUserid(); 
         String pass=ob.getPassword();
         
         PreparedStatement pst=con.prepareStatement("Select * from club_owner"+" where userid=? and password=?");
         pst.setString(1,uid);
         pst.setString(2,pass);
         
         ResultSet rs= pst.executeQuery();
         if(rs.isBeforeFirst())
             b=true;
    }
     
     catch(Exception e)
             {
                 e.printStackTrace();
             }
 return b;
 }
     public int insertOwner(Club_OwnerBean ob)
     {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
       
        //String pass= UUID.randomUUID().toString().substring(0,8);
        
        String uid=ob.getUserid();
        //String cid=ob.getClub_id();
        String name=ob.getOwner_name();
        String pass=ob.getPassword();
        String cntct=ob.getContact_no();
        
        PreparedStatement pst=con.prepareStatement("insert into club_owner values(?,?,?,?,?)");
        pst.setString(1,uid);
        pst.setString(2,pass);
        pst.setString(3,cntct);
        pst.setString(4,name);
        pst.setString(5,null);
        
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
     
     public int updateUid(String u,Club_OwnerBean ob)
    {
      String old_id = ob.getUserid();
      int count=0;
       try{
        
        Connection con = 
         MydbConnection.getDbConnection();
        
          PreparedStatement pst = 
        con.prepareStatement("update club_owner set "
                + "user_id = ? where user_id = ?");
          
          pst.setString(1, u);
          pst.setString(2, old_id);
          
          count = pst.executeUpdate();
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
       
       return count;
    }
     
    public int updatePass(Club_OwnerBean ob)
      {
          String uid=ob.getUserid(); 
          String pass= UUID.randomUUID().toString().substring(0,8);
          int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();  
          PreparedStatement pst=con.prepareStatement("update club_owner set "+"password=? where userid=?");
          pst.setString(1, pass);
          pst.setString(2, uid);
        count=pst.executeUpdate();
         }
        
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
      }
    
}
