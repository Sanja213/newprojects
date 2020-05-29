package education.departament.depaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.departament.ListDepartament;

public class ChekDep {
	public static boolean chekDepNum(HttpServletRequest req,ArrayList<Departament> list) {//проверяем есть ли такой № отдел
			
		int number=Integer.parseInt(req.getParameter("number"));
		for(Departament q:list) {
		if(q.getId()==(number)) return true;}
		return false;
		}

	public static String chekDepName(HttpServletRequest req,ArrayList<Departament> list) {//возвращаем id отдела по имени из req
		String depart = "???";
		for(Departament q:list) {
if(q.getName().equalsIgnoreCase(req.getParameter("name"))) 
	depart=q.getName();}
return depart;}

		
		

	public static void delFrom(ArrayList<Departament> s,int num) {//удаляем отдел по номеру
	  s.remove(num);	
	}

	public static void addList(ArrayList<Departament> s,int num,HttpServletRequest req) {//добавляем отдел по № из req
		if(req.getParameter("number")!=null && req.getParameter("name")!=null && req.getParameter("manager")!=null)
		s.add(new Departament(Integer.parseInt(req.getParameter("number")),req.getParameter("name"),req.getParameter("manager")));
	}
	}

