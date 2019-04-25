
package dao;
import java.sql.*;
import dto.AdminBean;
import dbcon.MydbConnection;
import java.io.PrintWriter;

public class AdminDAO {
 public boolean isUserValid(AdminBean ob)
 {  boolean b=false;
     try
     {
         Connection con=MydbConnection.getDbConnection();
         
         String uid=ob.getUserid(); 
         String pass=ob.getPassword();
         
         PreparedStatement pst=con.prepareStatement("Select * from admin where userid=? and password=?");
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
     
 System.out.println(b);
 return b;
 }
}
