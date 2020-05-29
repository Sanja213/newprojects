package factory.position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Position implements Comparable{
private int id;
private String name;
private double tarif;

public Position(int id, String name, double tarif) {
	this.id = id;
	this.name = name;
	this.tarif = tarif;
}

public Position(ResultSet rs) {
	try {
		this.id = Integer.parseInt(rs.getString("idposition"));
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (SQLException e) {
			e.printStackTrace();
	}
	try {
		this.name = rs.getString("nameposition");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		this.tarif = Double.parseDouble(rs.getString("tarif"));
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public Position() {
	}

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

public double getTarif() {
	return tarif;
}

public void setTarif(double tarif) {
	this.tarif = tarif;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(tarif);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Position other = (Position) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (Double.doubleToLongBits(tarif) != Double.doubleToLongBits(other.tarif))
		return false;
	return true;
}

@Override
public int compareTo(Object o) {
	
	return this.toString().compareTo(o.toString());
}




}
