package factory.departament;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Departament implements Comparable{
	int idDep;
	String nameDep;
	
	

	public int getIdDep() {
		return idDep;
	}



	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}



	public String getNameDep() {
		return nameDep;
	}



	public void setNameDep(String nameDep) {
		this.nameDep = nameDep;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDep;
		result = prime * result + ((nameDep == null) ? 0 : nameDep.hashCode());
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
		Departament other = (Departament) obj;
		if (idDep != other.idDep)
			return false;
		if (nameDep == null) {
			if (other.nameDep != null)
				return false;
		} else if (!nameDep.equals(other.nameDep))
			return false;
		return true;
	} 
	
	@Override
	public String toString() {
		return "Departament [idDep=" + idDep + ", nameDep=" + nameDep + "]";
	}

	@Override
	public int compareTo(Object o) {
		
		return this.toString().compareTo(o.toString());
	}

	public Departament(int idDep, String nameDep) {
		this.idDep = idDep;
		this.nameDep = nameDep;
	}

	public Departament() {
	}



	public Departament(ResultSet rs) {
		try {
			this.idDep = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.nameDep = rs.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
		

}
