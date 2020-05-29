package factory.position.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import factory.db.ManageSystem;
import factory.position.Position;

public class CheckPosition {
	public static boolean checkPosition(HttpServletRequest req) {//проверяет есть ли должность из запроса по названию в бд, возвращает false
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Position> list=ms.getAllPositions();
		for(Position p:list) {
			if(p.getName().equalsIgnoreCase(req.getParameter("namedep"))) return false;
		}
		return true;
		
	}

}
