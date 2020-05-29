package factory.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Worker.Worker;
import Worker.action.ChooseWorker;
import factory.db.ManageSystem;
import factory.departament.Departament;
import factory.departament.action.ChooseDep;
import factory.position.Position;
import factory.position.action.ChoosePos;

@WebServlet("/changeworker")
public class ChangeWorkerServlet extends HttpServlet{
	private static final long serialVersionUID = 3837137597036528657L;
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8");
		 ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Departament> list=manageSystem.getAllDepartaments();
		   req.setAttribute("departaments", list);
		   
		   ArrayList<Position> list1=manageSystem.getAllPositions();
		   req.setAttribute("positions", list1);
		   ArrayList<Worker> list2=manageSystem.getAllWorkers();
		   req.setAttribute("workers", list2);   
		  	 
		 if((req.getParameter("enter")!=null)&&(!req.getParameter("idworker").equalsIgnoreCase(""))&&
				 ((!req.getParameter("nameworker").equalsIgnoreCase(""))||(!req.getParameter("lastnameworker").equalsIgnoreCase(""))||
						 (!req.getParameter("dateofbirth").equalsIgnoreCase(""))||
						 (!req.getParameter("positionworker").equalsIgnoreCase(""))||
						 (!req.getParameter("departamentworker").equalsIgnoreCase("")))) {
			 ArrayList<Worker> workers = new ArrayList<>();
			 Worker newWorker=new Worker();
			 Worker oldWorker = new Worker();    
			 
			 if(!req.getParameter("idworker").equalsIgnoreCase("")) {     
				  	 oldWorker=ChooseWorker.chooseWorkerId(req);
				  	 newWorker=ChooseWorker.chooseWorkerId(req);
					 if(!req.getParameter("nameworker").equalsIgnoreCase("")) {   
						 newWorker.setName(req.getParameter("nameworker"));
					 }	
					 if(!req.getParameter("lastnameworker").equalsIgnoreCase("")) {   
						 newWorker.setLastName(req.getParameter("lastnameworker"));
					 }	
					 if(!req.getParameter("dateofbirth").equalsIgnoreCase("")) {  System.out.println(req.getParameter("dateofbirth")); 
					 Date dateOfBirth = new Date();
					 
					 try {
						String date=req.getParameter("dateofbirth");
						String[] date1=date.split("\\W");
						if(date1[0].length()==4) date=date1[2]+"."+date1[1]+"."+date1[0];
						else date=date1[0]+"."+date1[1]+"."+date1[2];
						SimpleDateFormat old=new SimpleDateFormat("dd.MM.yyyy");
							dateOfBirth= old.parse(date); 
								} catch (ParseException e) {
								e.printStackTrace();
						}
					
						 newWorker.setDateOfBirth(dateOfBirth);
						 
					 }	
					 if(!req.getParameter("positionworker").equalsIgnoreCase("")) {   
						 newWorker.setPosition(ChoosePos.choosePosName(req.getParameter("positionworker")));
					 }	
					 if(!req.getParameter("departamentworker").equalsIgnoreCase("")) {   
						 newWorker.setDepartament(ChooseDep.chooseDepName(req.getParameter("departamentworker")));
					 }	
					
					 
				 
			 }
			manageSystem.updateWorker(newWorker);
			 workers.add(oldWorker);
			 workers.add(newWorker);
			 req.setAttribute("outwork", workers); 
			 list2=manageSystem.getAllWorkers();
			   req.setAttribute("workers", list2);
				 
		 }
		 try {                                                                          
				getServletContext().getRequestDispatcher("/web/ChengeEmp.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
