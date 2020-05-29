package education.webservlet;
import education.worker.ListWorkers;
import education.worker.Worker;
import education.worker.worceraction.WorkAddList;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import education.departament.Departament;
import education.departament.ListDepartament;
import education.departament.depaction.AddDepart;
import education.departament.depaction.AddManager;
import education.departament.depaction.ChekAction;
import education.departament.depaction.ChekDep;
import education.departament.depaction.DelDepNum;

@WebServlet("/departaments")
public class DepartamentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 8077217210861043257L;
	
	
	protected  void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ArrayList<Worker> list1=new ArrayList<Worker>();
		 int answer = 0;	      
	      try {
			answer = ChekAction.checkAction(req);
			} catch (SQLException e) {
			
			e.printStackTrace();
		}   
	        if (answer==1) {
	        	if((!req.getParameter("number").equals(""))&&req.getParameter("name")
	        			.equals("")&&req.getParameter("manager").equals("")){
	            		try {
	            			DelDepNum.delDepNum(ListDepartament.dep, req);}
	        		catch(NumberFormatException e) {   e.printStackTrace();}
	        		}
	        	if((!req.getParameter("number").equals(""))&&(!req.getParameter("name")
	        			.equals(""))&&(!req.getParameter("manager").equals(""))){
	        		try {
	        			AddDepart.addDepart(ListDepartament.dep, req);	        		
	        		}
	        		catch(NumberFormatException e) {    	
        		}
	        		}
	        	if((!req.getParameter("number").equals(""))||(!req.getParameter("name")
	        			.equals(""))&&(req.getParameter("manager").equals(""))){
	        	try {
	        		AddDepart.addDepartFull(ListDepartament.dep, req);	
	           		       		
	        		}
	        		catch(NumberFormatException e) {    	
        		}
	        		}
	        }

	    	
   	        
	        if (answer==2 ) {//если нажата кнопка изменить отдел 
	        	try {        	      	
	           	
	        	if(!req.getParameter("manager").equalsIgnoreCase(""))
	        			{
	           		if(!req.getParameter("name").equalsIgnoreCase("")&&req.getParameter("number").equalsIgnoreCase("")) 
	        		{ AddManager.addManagerName(ListDepartament.dep,req);
	        		}
	        		if(req.getParameter("name").equalsIgnoreCase("")&&(!req.getParameter("number").equalsIgnoreCase(""))) 
	        		{
	        			AddManager.addManagerNum(ListDepartament.dep, req);}
	        		if(!req.getParameter("name").equalsIgnoreCase("")&&(!req.getParameter("number").equalsIgnoreCase(""))) 
	        		{
	        			AddManager.addManagerNum(ListDepartament.dep, req);
	        		}	        		
	        			}       	        			
	        	        	 	        	
	        	}catch(NumberFormatException e) {  e.printStackTrace(); } 	} 
	        if (answer==3 ) {                	
	        	
	        	if((!req.getParameter("name").equals(""))&&req.getParameter("name")!=null) {
	        		String depart =ChekDep.chekDepName(req,ListDepartament.dep);
	        		WorkAddList.workAddList(ListWorkers.workers,list1,depart);
	        	}
	        	if((!req.getParameter("manager").equals(""))&&req.getParameter("manager")!=null) {
	        		String depart = WorkAddList.numFromMan(ListDepartament.dep,req);
	        		WorkAddList.workAddList(ListWorkers.workers,list1,depart);
	        		}
	        		if((!req.getParameter("number").equals(""))&&req.getParameter("number")!=null) {
		        	     		try {
		        		String r=WorkAddList.numFomnum(req,ListDepartament.dep);
		        		WorkAddList.workAddList(ListWorkers.workers,list1,r);
		        		}
		        		catch(NumberFormatException e) {list1.addAll(ListWorkers.workers);     	
	        		}
		        		}	        	
	        	
	        }
	     //   int form=Integer.parseInt((String)req.getParameter("number"));
	        req.setAttribute("form", list1);
	        getServletContext().getRequestDispatcher("/web/departament.jsp").forward(req, resp); 
	}
	 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}