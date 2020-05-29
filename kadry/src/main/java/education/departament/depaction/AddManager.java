package education.departament.depaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.departament.ListDepartament;
import education.worker.worceraction.WorkAddList;

public class AddManager {
	public static void addManagerNum(ArrayList<Departament> list,HttpServletRequest req) throws NumberFormatException{
	int	id=WorkAddList.numToNum(req);
	String manager=req.getParameter("manager");
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId()==id)
				list.get(i).setManager(manager);
		}
		}
	
	public static void addManagerName(ArrayList<Departament> list,HttpServletRequest req) {
	String name=req.getParameter("name");
	String manager=req.getParameter("manager");
	for(int i=0;i<list.size();i++) {
		if(list.get(i).getName().equalsIgnoreCase(name))
			list.get(i).setManager(manager);
}
}
	
	}