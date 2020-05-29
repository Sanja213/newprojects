package education.worker.worceraction;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.worker.Worker;

public class WorkAddList {
public static void workAddList(ArrayList<Worker> list,ArrayList<Worker> list1,String depart) {//добавление в вывод рабочих по отделу
	for(Worker i:list) {
		if(i.getDepartamentId().equalsIgnoreCase(depart)) {
			list1.add(i);
		}
	}
}
public static String numFromMan(ArrayList<Departament> list,HttpServletRequest req) {
		String depart = "???";
		for(Departament q:list) {
			if(q.getManager().equalsIgnoreCase(req.getParameter("manager"))) {
				depart=q.getName();
			}
		}
		return depart;
}

public static String numFomnum(HttpServletRequest req,ArrayList<Departament> list)throws NumberFormatException{
	
     String r="???";
	if(req.getParameter("number")!=null)
		for(Departament q:list) {
			if(q.getId()==Integer.parseInt(req.getParameter("number"))) {
				r=q.getName();}
	
		}
	return r;	
}
public static int numToNum(HttpServletRequest req)throws NumberFormatException{
	
    int r=-1;
	if(req.getParameter("number")!=null)
		r=Integer.parseInt(req.getParameter("number"));
	
	
	return r;	
}
}
