package factory.departament.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import factory.db.ManageSystem;
import factory.departament.Departament;


public class ChooseDep {
	public static Departament chooseDep(HttpServletRequest req) {//возвращает отдел из запроса по имени из бд
		Departament dep=new Departament();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Departament> list=ms.getAllDepartaments();
		for(Departament d:list) {
			if(d.getNameDep().equalsIgnoreCase(req.getParameter("namedep"))||d.getNameDep().equalsIgnoreCase(req.getParameter("depname"))) {
				dep.setIdDep(d.getIdDep());
				dep.setNameDep(d.getNameDep());
			} 
		}
		
		return dep;
		}
	public static Departament chooseDepId(HttpServletRequest req) {// возвращает отдел из запроса  по id из бд
		Departament dep = new Departament();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Departament> list=ms.getAllDepartaments();
				for(Departament d:list) {
			if(d.getIdDep()==(Integer.parseInt(req.getParameter("iddep")))) {
				dep.setIdDep(d.getIdDep());
				dep.setNameDep(d.getNameDep());
			} 
		}
		
		return dep;
		}
	
	public static Departament chooseIdDep(int id) {// возвращает отдела  по id из бд
		Departament dep = new Departament();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Departament> list=ms.getAllDepartaments();
				for(Departament d:list) {
			if(d.getIdDep()==id) {
				dep.setIdDep(d.getIdDep());
				dep.setNameDep(d.getNameDep());
			} 
		}
		
		return dep;
		}
	public static Departament chooseDepName(String name) {//возвращает отдел из запроса по имени из бд
		Departament dep=new Departament();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Departament> list=ms.getAllDepartaments();
		for(Departament d:list) {
			if(d.getNameDep().equalsIgnoreCase(name)) {
				dep.setIdDep(d.getIdDep());
				dep.setNameDep(d.getNameDep());
			} 
		}
		
		return dep;
		}

}
