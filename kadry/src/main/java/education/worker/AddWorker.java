package education.worker;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.departament.ListDepartament;

public class AddWorker {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
public static void addWorker(HttpServletRequest req, ArrayList<Worker> list) {
	
	int number=-1;
	String name="";
	String patronomic="";
	String lastname="";
	Date date=new Date();
	String position="";
    String iddep="???";
    number=numFomnum(req);
    for(int i=0;i<ListWorkers.workers.size();i++)
    	if(ListWorkers.workers.get(i).getId()==number)
    		return;
	
number=numFomnum(req);
name=req.getParameter("name");
patronomic=req.getParameter("patronomic");
lastname=req.getParameter("lastname");
try {
	//System.out.println(sdf.parse(req.getParameter("dateofbirth")));
	SimpleDateFormat old=new SimpleDateFormat("yyyy-MM-dd");System.out.println(req.getParameter("dateofbirth"));
	date= old.parse(req.getParameter("dateofbirth"));System.out.println(date);
} catch (ParseException e) {
		e.printStackTrace();
}

if(req.getParameter("position")!=null||(!req.getParameter("position").equals(""))) {position=req.getParameter("position");}
try{
	if(req.getParameter("departament")!=null||(!req.getParameter("departament").equals("")))
		{iddep=req.getParameter("departament");}
}catch(NumberFormatException e) {e.printStackTrace();}


list.add(new Worker(number, name, patronomic, lastname, date, position, iddep));
}



public static int numFomnum(HttpServletRequest req) {
	int r=-1;
	try{	
	if(req.getParameter("number")!=null)
	r=Integer.parseInt(req.getParameter("number"));
	}catch(NumberFormatException e) {e.printStackTrace();}
	return r;	
}
}