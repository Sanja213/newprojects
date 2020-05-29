package Worker.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Worker.Worker;
import factory.db.ManageSystem;


public class CheckWorker {
	
	public static boolean checkName(HttpServletRequest req) {// проверяет есть ли введенная должность в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		for(Worker w:list) {
			if((w.getName().equalsIgnoreCase(req.getParameter("name")))&&
					(w.getLastName().equalsIgnoreCase(req.getParameter("lastname")))) return true;
		}
		return false;
		
	}
	public static boolean checkId(HttpServletRequest req) {//проверяет есть ли введенный id  в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		int id=-1;
		try {
		id=Integer.parseInt(req.getParameter("id"));
		}catch(NumberFormatException e) {e.printStackTrace();}
		for(Worker w:list) {
			if(w.getId()==id) return true;
		}
		return false;
	}
	
	public static boolean checkFullName(HttpServletRequest req) {// проверяет есть ли введенная должность в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		String[] array = req.getParameter("nameworker").split(" ");
		for(Worker w:list) {
			if((w.getName().equalsIgnoreCase(array[0]))&&
					(w.getLastName().equalsIgnoreCase(array[1]))) return true;
		}
		return false;
		
	}

}
