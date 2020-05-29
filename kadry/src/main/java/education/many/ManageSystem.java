package education.many;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;


public class ManageSystem {
	
	 private static Connection con;
	    private static ManageSystem instance;
	    private static DataSource dataSource;
	 
	    private ManageSystem() {
	    }
	 
	    public static synchronized ManageSystem getInstance() {
	        if (instance == null) {
	            try {
	                instance = new ManageSystem();
	                con = DriverManager.getConnection(
	    					Config.getProperty(Config.DB_URL),
	    					Config.getProperty(Config.DB_LOGIN),
	    					Config.getProperty(Config.DB_PASSWORDL));
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return instance;
	    }
	    
	    

}
