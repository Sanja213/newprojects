package Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import factory.departament.Departament;
import factory.departament.action.ChooseDep;
import factory.position.Position;
import factory.position.action.ChoosePos;

public class Worker implements Comparable<Worker>{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	int id;
	String name;
	String lastName;
	Date dateOfBirth;
	Position position;
	Departament departament;
	
	
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	public String getBirth() {
		return sdf.format(dateOfBirth);}
	
	
	public Worker() {
	}
	
	public Worker(int id, String name, String lastName, Date dateOfBirth, Position position, Departament departament) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.position = position;
		this.departament = departament;
	}

	public Worker(ResultSet rs) {
		try {
			this.id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.name = rs.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.lastName = rs.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.dateOfBirth = rs.getDate(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.position = ChoosePos.chooseIdPos(rs.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.departament = ChooseDep.chooseIdDep(rs.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((departament == null) ? 0 : departament.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Worker other = (Worker) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (departament == null) {
			if (other.departament != null)
				return false;
		} else if (!departament.equals(other.departament))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dateOfBirth=" + 
	    DateFormat.getDateInstance(DateFormat.SHORT).format(dateOfBirth) 
				+ ", position=" + position.getName() + ", departament=" + departament.getNameDep() + "]";
	}

	@Override
	public int compareTo(Worker o) {
		
		 return this.toString().compareTo(o.toString());
	}

}
