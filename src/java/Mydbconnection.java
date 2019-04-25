
import java.sql.*;

public class Mydbconnection {
    static Connection con;
 public static Connection getDbConnection()
 {
     try
     {
         Class.forName("con.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306?club_reserve_db","root","");
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
     return con;
 }
}
