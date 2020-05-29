package factory.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mysql.jdbc.Driver;

import Worker.Worker;
import factory.departament.Departament;
import factory.position.Position;


public class ManageSystem {
	
	private static final String REQUEST_POSITION = "select idposition, nameposition, tarif from factory.positions;";	
	private static final String INSERT_POSITION="INSERT INTO factory.positions (nameposition, tarif)  VALUES( ?,  ?);";
	private static final String DELETE_POSITION="DELETE FROM factory.positions WHERE nameposition =  ?";
	private static final String UPDATE_POSITION="UPDATE factory.positions SET nameposition=?, tarif=? WHERE idposition=?";
	
	private static final String REQUEST_DEPARTAMENT = "select iddepartaments, namedepartaments from factory.departaments;";
	private static final String INSERT_DEPARTAMENT="INSERT INTO factory.departaments (namedepartaments)  VALUES( ?);";
	private static final String DELETE_DEPARTAMENT="DELETE FROM factory.departaments WHERE namedepartaments =  ?";
	private static final String UPDATE_DEPARTAMENT="UPDATE factory.DEPARTAMENTS SET namedepartaments=? WHERE iddepartaments=?";
	
	private static final String REQUEST_WORKER = "select idworker, name, lastname, dateOfBirth, position, departament from factory.workers;";	
	private static final String INSERT_WORKER="INSERT INTO factory.workers (name, lastname, dateOfBirth, position, departament)"+
	                           "VALUES( ?, ?, ?, ?, ?);";
	private static final String DELETE_WORKER="DELETE FROM factory.workers WHERE name =  ? and lastname = ?";
	private static final String UPDATE_WORKER="UPDATE factory.workers SET name=?, lastname=?, dateOfBirth=?,position=?, departament = ? WHERE idworker=?";
	
	 private static Connection con;
	    private static ManageSystem instance;
	    	 
	    private ManageSystem() {
	    }
	 
	    public static synchronized ManageSystem getInstance() {
	    	com.mysql.cj.jdbc.Driver driver = null;
			try {
				driver = new com.mysql.cj.jdbc.Driver();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
            try {
				DriverManager.registerDriver(driver);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} 
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
	    public ArrayList<Position> getAllPositions(){   
	    	ArrayList<Position> result=new ArrayList<>();
	    	try(		    			
	    			Statement stat = con.createStatement();
	    			ResultSet rs = stat.executeQuery(REQUEST_POSITION);
	    	) {
	    	    	
	    			while(rs.next()) {
	    				Position position = new Position(rs);
	    				result.add(position);
	    			}
	    			
	    	}
	    	catch(Exception ex) {ex.printStackTrace();}
	    	return result;
	    }
	    
	    public void createGroup(Position position) {
	    	 try(
	      		PreparedStatement stmt = con.prepareStatement(INSERT_POSITION);
	      			
	      	) {
	    		 stmt.setString(1, position.getName());
	 	        stmt.setDouble(2, position.getTarif());
	 	       stmt.execute();
	      	}
	      	catch(SQLException ex) {ex.printStackTrace();} 
	    }
	    
	    public void delPosition(Position position)
	    {
	    	try(
		  	  		PreparedStatement stmt = con.prepareStatement(DELETE_POSITION);
		  	  			
		  	  	) {  stmt.setString(1, position.getName());
		             stmt.execute();
		  	  	}
		  	  	catch(SQLException ex) {ex.printStackTrace();} 	
	    }
	    
	    public void updatePosition(Position position) {
	    	 try(
	 	  		PreparedStatement stmt = con.prepareStatement(UPDATE_POSITION);
	 	  			
	 	  	) {  stmt.setString(1, position.getName());
	        stmt.setDouble(2, position.getTarif());
	        stmt.setInt(3, position.getId());
	        stmt.execute();
	 	  	}
	 	  	catch(SQLException ex) {ex.printStackTrace();} 
	    }
	    
	    public ArrayList<Departament> getAllDepartaments(){   
	    	ArrayList<Departament> result=new ArrayList<>();
	    	try(		    			
	    			Statement stat = con.createStatement();
	    			ResultSet rs = stat.executeQuery(REQUEST_DEPARTAMENT);
	    	) {
	    	    	
	    			while(rs.next()) {
	    				Departament departament = new Departament(rs);
	    				result.add(departament);
	    			}
	    			
	    	}
	    	catch(Exception ex) {ex.printStackTrace();}
	    	return result;
	    }
	    
	    public void createDepartament(Departament departament) {
	    	 try(
	      		PreparedStatement stmt = con.prepareStatement(INSERT_DEPARTAMENT);
	      			
	      	) {
	    		 stmt.setString(1, departament.getNameDep());
	 	      stmt.execute();
	      	}
	      	catch(SQLException ex) {ex.printStackTrace();} 
	    }
	    
	    public void delDepartament(Departament departament)
	    {
	    	try(
		  	  		PreparedStatement stmt = con.prepareStatement(DELETE_DEPARTAMENT);
		  	  			
		  	  	) {  stmt.setString(1, departament.getNameDep());
		             stmt.execute();
		  	  	}
		  	  	catch(SQLException ex) {ex.printStackTrace();} 	
	    }
	    
	    public void updateDepartament(Departament departament) {
	    	 try(
	 	  		PreparedStatement stmt = con.prepareStatement(UPDATE_DEPARTAMENT);
	 	  			
	 	  	) {  stmt.setString(1, departament.getNameDep());
	          stmt.setInt(2, departament.getIdDep());
	        stmt.execute();
	 	  	}
	 	  	catch(SQLException ex) {ex.printStackTrace();} 
	    }
	    
	    public ArrayList<Worker> getAllWorkers(){   
	    	ArrayList<Worker> result=new ArrayList<>();
	    	try(		    			
	    			Statement stat = con.createStatement();
	    			ResultSet rs = stat.executeQuery(REQUEST_WORKER);
	    	) {
	    	    	
	    			while(rs.next()) {
	    				Worker worker = new Worker(rs);
	    				result.add(worker);
	    			}
	    			
	    	}
	    	catch(Exception ex) {ex.printStackTrace();}
	    	return result;
	    }
	    
	    public void createWorker(Worker worker) {
	    	 try(
	      		PreparedStatement stmt = con.prepareStatement(INSERT_WORKER);
	      			
	      	) {
	    		 stmt.setString(1, worker.getName());
	 	        stmt.setString(2, worker.getLastName());
	 	       java.sql.Date sqlDate = new java.sql.Date(worker.getDateOfBirth().getTime());
	 	        stmt.setDate(3, sqlDate);
	 	        stmt.setInt(4, worker.getPosition().getId());
	 	        stmt.setInt(5, worker.getDepartament().getIdDep());
	 	       stmt.execute();
	      	}
	      	catch(SQLException ex) {ex.printStackTrace();} 
	    }
	    
	    public void delWorker(Worker worker)
	    {
	    	try(
		  	  		PreparedStatement stmt = con.prepareStatement(DELETE_WORKER);
		  	  			
		  	  	) {  stmt.setString(1, worker.getName());
		  	  stmt.setString(2, worker.getLastName());
		             stmt.execute();
		  	  	}
		  	  	catch(SQLException ex) {ex.printStackTrace();} 	
	    }
	    
	    public void updateWorker(Worker worker) {
	    	 try(
	 	  		PreparedStatement stmt = con.prepareStatement(UPDATE_WORKER);
	 	  			
	 	  	) {  stmt.setString(1, worker.getName());
 	        stmt.setString(2, worker.getLastName());
 	       java.sql.Date sqlDate = new java.sql.Date(worker.getDateOfBirth().getTime());
	        stmt.setDate(3, sqlDate);
 	        stmt.setInt(4, worker.getPosition().getId());
 	        stmt.setInt(5, worker.getDepartament().getIdDep());
	        stmt.setInt(6, worker.getId());
	        stmt.execute();
	 	  	}
	 	  	catch(SQLException ex) {ex.printStackTrace();} 
	    }
}
