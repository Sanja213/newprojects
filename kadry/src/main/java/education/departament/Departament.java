package education.departament;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Departament {
private int id;
private String name;
private String manager;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public Departament() {
	}


public Departament(int id, String name, String manager) {
	this.id = id;
	this.name = name;
	this.manager = manager;
}
public Departament(ResultSet rs) throws SQLException {
	setId(rs.getInt(1));
	setName(rs.getString(2));
	setManager(rs.getString(3));
}
@Override
public String toString() {
	return id+" "+ name+" "+manager;
}


}

