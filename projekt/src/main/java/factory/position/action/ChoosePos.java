package factory.position.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import factory.db.ManageSystem;
import factory.position.Position;

public class ChoosePos {
public static Position choosePos(HttpServletRequest req) {//возвращает должность из запроса по имени из бд
	Position pos=new Position();
	ManageSystem ms=ManageSystem.getInstance();
	ArrayList<Position> list=ms.getAllPositions();
	for(Position p:list) {
		if(p.getName().equalsIgnoreCase(req.getParameter("namedep"))||p.getName().equalsIgnoreCase(req.getParameter("namepos"))) {
			pos.setId(p.getId());
			pos.setName(p.getName());
			pos.setTarif(p.getTarif());
		} 
	}
	
	return pos;
	}

public static Position choosePosName(String name) {//возвращает должность из запроса по имени из бд
	Position pos=new Position();
	ManageSystem ms=ManageSystem.getInstance();
	ArrayList<Position> list=ms.getAllPositions();
	for(Position p:list) {
		if(p.getName().equalsIgnoreCase(name)) {
			pos.setId(p.getId());
			pos.setName(p.getName());
			pos.setTarif(p.getTarif());
		} 
	}
	
	return pos;
	}
public static Position choosePosId(HttpServletRequest req) {// возвращает должность из запроса  по id из бд
	Position pos=new Position();
	ManageSystem ms=ManageSystem.getInstance();
	ArrayList<Position> list=ms.getAllPositions();
	for(Position p:list) {
		if(p.getId()==(Integer.parseInt(req.getParameter("iddep")))) {
			pos.setId(p.getId());
			pos.setName(p.getName());
			pos.setTarif(p.getTarif());
		} 
	}
	
	return pos;
	}

public static Position chooseIdPos(int id) {// возвращает должность из запроса  по id из бд
	Position pos=new Position();
	ManageSystem ms=ManageSystem.getInstance();
	ArrayList<Position> list=ms.getAllPositions();
	for(Position p:list) {
		if(p.getId()==id) {
			pos.setId(p.getId());
			pos.setName(p.getName());
			pos.setTarif(p.getTarif());
		} 
	}
	
	return pos;
	}

}
