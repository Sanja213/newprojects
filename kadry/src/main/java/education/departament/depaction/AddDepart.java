package education.departament.depaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.departament.ListDepartament;
import education.worker.worceraction.WorkAddList;

public class AddDepart {
public static void addDepart(ArrayList<Departament> list,HttpServletRequest req)throws NumberFormatException{
	int temp=0;
	int id=WorkAddList.numToNum(req);
	String name=req.getParameter("name");
	String manager=req.getParameter("manager");
	for(Departament d:list) {
		if(d.getId()==id) temp++;
		if(d.getName().equalsIgnoreCase(name)) temp++;
		if((d.getManager()!=null))
				{if(d.getManager().equalsIgnoreCase(manager)) temp++;}
	}	        		        		
	if(temp==0)
	list.add(new Departament(id,name,manager));	   
	}
public static void addDepartFull(ArrayList<Departament> list,HttpServletRequest req)throws NumberFormatException{
	int temp=0;
	int id=WorkAddList.numToNum(req);
	String name=req.getParameter("name");
		for(Departament d:list) {
		if(d.getId()==id) temp++;
		if(d.getName().equalsIgnoreCase(name)) temp++;
		      		}	        		        		
	if(temp==0) {       		      			
		Departament dep =new Departament();
dep.setId(id);
dep.setName(name);
	list.add(dep);
}
}}
