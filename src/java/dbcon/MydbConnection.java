package dbcon;




import java.sql.*;

public class MydbConnection {
    static Connection con;
 public static Connection getDbConnection()
 {
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/club_reserve_db","root","");
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
     return con;
 }
}

/*
package dbcon;

import java.sql.*;

public class MydbConnection {
    static Connection con;
 public static Connection getDbConnection()
 {
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/club_reserve_db","root","");
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
     return con;
 }
}
*/