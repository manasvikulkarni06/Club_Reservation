
package dao;
import dbcon.MydbConnection;
import dto.Club_MemberBean;
import java.sql.*;
import java.util.UUID;

public class Club_MemberDAO {
     public boolean isUserValid(Club_MemberBean ob)
 {  boolean b=false;
     try
     {
         Connection con=MydbConnection.getDbConnection();
         
         String uid=ob.getUserid(); 
         String pass=ob.getPassword();
         
         PreparedStatement pst=con.prepareStatement("Select * from club_member"+"where userid=? and password=?");
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
     public int insertMember(Club_MemberBean ob)
     {
         int count=0;
         try
         {
      Connection con= MydbConnection.getDbConnection();
          String pass= UUID.randomUUID().toString().substring(0,8);
       
        String uid=ob.getUserid();
        String cid=ob.getClub_id();
        String name=ob.getMember_name();
        String cntct=ob.getContact_no();
        
        PreparedStatement pst=con.prepareStatement("insert into club_member"+"values(?,?,?,?,?)");
        pst.setString(1,uid);
        pst.setString(2,pass);
        pst.setString(3,cid);
        pst.setString(4,cntct);
        pst.setString(5,name);
        
        count=pst.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return count;
     }
     
      public int updatePass(Club_MemberBean ob)
      {
           int count=0;
           String pass= UUID.randomUUID().toString().substring(0,8);
            String uid=ob.getUserid();
         try
         {
      Connection con= MydbConnection.getDbConnection();
          
          PreparedStatement pst=con.prepareStatement("update club_member set password=? where userid=?");
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

    

