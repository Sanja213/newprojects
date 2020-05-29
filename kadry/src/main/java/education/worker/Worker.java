package education.worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
private int id;	
private String name;
private String patronomicName;
private String lastName;
private Date birthDay;
private String position;
private String departamentId;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPatronomicName() {
	return patronomicName;
}
public void setPatronomicName(String patronomicName) {
	this.patronomicName = patronomicName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getBirthDay() throws ParseException {
	return birthDay;
}
public String getBirth() throws ParseException {
	return sdf.format(birthDay);}

public void setBirthDay(Date birthDay) {
	this.birthDay = birthDay;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getDepartamentId() {
	return departamentId;
}
public void setDepartamentId(String departamentId) {
	this.departamentId = departamentId;
}
public Worker() {
	super();
}

public Worker(int id, String name, String patronomicName, String lastName, Date birthDay, String position,
		String departamentId) {
	super();
	this.id = id;
	this.name = name;
	this.patronomicName = patronomicName;
	this.lastName = lastName;
	this.birthDay = birthDay;
	this.position = position;
	this.departamentId = departamentId;
}
public Worker(ResultSet rs) throws SQLException {
	 setId(rs.getInt(1));
	    setName(rs.getString(2));
	    setPatronomicName(rs.getString(3));
	    setLastName(rs.getString(4));
	    setBirthDay(rs.getDate(5));
	    setPosition(rs.getString(6));
	    setDepartamentId(rs.getString(7));
}
public String toString() {
    return id+" "+name + " " + patronomicName + " " + lastName + " "
            + DateFormat.getDateInstance(DateFormat.SHORT).format(birthDay)
            + " " + position + " " +departamentId ;
}

public int compareTo(Object obj) {
    return this.toString().compareTo(obj.toString());
}

}
