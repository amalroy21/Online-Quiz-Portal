package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {

      public static Connection getConnection() throws ClassNotFoundException, SQLException {
                 
       	  Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection("jdbc:oracle:thin:Amal/password@localhost:1521/xe");
          return con;
      }
}

