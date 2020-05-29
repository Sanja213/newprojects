package Worker.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Worker.Worker;
import factory.db.ManageSystem;

public class ChooseWorker {
	public static Worker chooseWorker(HttpServletRequest req) {//возвращает должность из запроса по имени из бд
		Worker w=new Worker();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		for(Worker wr:list) {
			if(wr.getName().equalsIgnoreCase(req.getParameter("name"))&&
			   wr.getLastName().equalsIgnoreCase(req.getParameter("lastname"))) {
				w.setId(wr.getId());
				w.setName(wr.getName());
				w.setLastName(wr.getLastName());
				w.setDateOfBirth(wr.getDateOfBirth());
				w.setPosition(wr.getPosition());
				w.setDepartament(wr.getDepartament());
			} 
		}
		
		return w;
		}
	public static Worker chooseWorkerId(HttpServletRequest req) {// возвращает должность из запроса  по id из бд
		Worker w=new Worker();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		
		
		for(Worker ws:list) {
			int id=-1;
			if(req.getParameter("id")!=null) id = Integer.parseInt(req.getParameter("id"));
			else {String[] array = req.getParameter("idworker").split(" ");
				id=Integer.parseInt(array[0]);}		
			
			if(ws.getId()==id) {
				w.setId(ws.getId());
				w.setName(ws.getName());
				w.setLastName(ws.getLastName());
				w.setDateOfBirth(ws.getDateOfBirth());
				w.setPosition(ws.getPosition());
				w.setDepartament(ws.getDepartament());
			} 
		}
		
		return w;
		}

	public static Worker chooseIdWorker(int id) {// возвращает должность из запроса  по id из бд
		Worker w=new Worker();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		for(Worker ws:list) {
			if(ws.getId()==id) {
				w.setId(ws.getId());
				w.setName(ws.getName());
				w.setLastName(ws.getLastName());
				w.setDateOfBirth(ws.getDateOfBirth());
				w.setPosition(ws.getPosition());
				w.setDepartament(ws.getDepartament());
			} 
		}
		
		return w;
		}
	public static Worker chooseWorkerFull(HttpServletRequest req) {//возвращает рабочего из запроса по имени из бд
		Worker w=new Worker();
		ManageSystem ms=ManageSystem.getInstance();
		ArrayList<Worker> list=ms.getAllWorkers();
		String[] array = req.getParameter("nameworker").split(" ");
		for(Worker wr:list) {
			if((wr.getName().equalsIgnoreCase(array[0]))&&
					(wr.getLastName().equalsIgnoreCase(array[1]))) {
				w.setId(wr.getId());
				w.setName(wr.getName());
				w.setLastName(wr.getLastName());
				w.setDateOfBirth(wr.getDateOfBirth());
				w.setPosition(wr.getPosition());
				w.setDepartament(wr.getDepartament());
			} 
		}
		
		return w;
		}
}
