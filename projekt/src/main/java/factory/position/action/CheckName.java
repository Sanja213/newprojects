package factory.position.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import factory.db.ManageSystem;
import factory.position.Position;

public class CheckName {
	public static boolean checkName(HttpServletRequest req) {// проверяет есть ли введенная должность в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Position> list=ms.getAllPositions();
		for(Position p:list) {
			if(p.getName().equalsIgnoreCase(req.getParameter("namedep"))) return true;
		}
		return false;
		
	}
	public static boolean checkId(HttpServletRequest req) {//проверяет есть ли введенный id  в бд
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Position> list=ms.getAllPositions();
		int id=-1;
		try {
		id=Integer.parseInt(req.getParameter("iddep"));
		}catch(NumberFormatException e) {e.printStackTrace();}
		for(Position p:list) {
			if(p.getId()==id) return true;
		}
		return false;
		
	}
}
