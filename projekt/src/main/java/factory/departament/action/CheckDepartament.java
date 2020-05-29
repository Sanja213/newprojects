package factory.departament.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import factory.db.ManageSystem;
import factory.departament.Departament;

public class CheckDepartament {
	public static boolean checkName(HttpServletRequest req) {// проверяет есть ли введенная должность в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Departament> list=ms.getAllDepartaments();
		for(Departament d:list) {
			if(d.getNameDep().equalsIgnoreCase(req.getParameter("namedep"))) return true;
		}
		return false;
		
	}
	public static boolean checkId(HttpServletRequest req) {//проверяет есть ли введенный id  в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Departament> list=ms.getAllDepartaments();
		int id=-1;
		try {
		id=Integer.parseInt(req.getParameter("iddep"));
		}catch(NumberFormatException e) {e.printStackTrace();}
		for(Departament d:list) {
			if(d.getIdDep()==id) return true;
		}
		return false;
		
	}

}
