package factory.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Worker.Worker;
import factory.db.ManageSystem;

@WebServlet("/worker")
public class WorkerServlet extends HttpServlet{
	private static final long serialVersionUID = 551710178190829570L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		  req.setCharacterEncoding("UTF-8"); 
		  ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Worker> list=manageSystem.getAllWorkers();
		   req.setAttribute("workers", list);
		   
		   if(req.getParameter("enter")!=null) {
			   ArrayList<Worker> workers =new ArrayList<>();
			   workers.addAll(list);
			   if(req.getParameter("idworker")!=null&&(!req.getParameter("idworker").equalsIgnoreCase(""))) {
				   int id=-1;
				   try {
				   id=Integer.parseInt(req.getParameter("idworker"));}
				   catch(NumberFormatException e) {e.printStackTrace();}
				     for(int i=0;i<workers.size();i++) {
					   if((req.getParameter("rad").equals("equally"))&&(workers.get(i).getId()!=id)) {workers.remove(i);i--;}
					   if((req.getParameter("rad").equals("more"))&&(workers.get(i).getId()<id)) {workers.remove(i);i--;}
					   if((req.getParameter("rad").equals("less"))&&(workers.get(i).getId()>id)) {workers.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("nameworker")!=null&&(!req.getParameter("nameworker").equalsIgnoreCase(""))) {
				   String name="";
				   try {
				   name=req.getParameter("nameworker");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<workers.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&(!workers.get(i).getName().equalsIgnoreCase(name)))
			{workers.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&(workers.get(i).getName().compareToIgnoreCase(name)<0)) 
			{workers.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&(workers.get(i).getName().compareToIgnoreCase(name)>0))
			{workers.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("lastnameworker")!=null&&(!req.getParameter("lastnameworker").equalsIgnoreCase(""))) {
				   String lastname="";
				   try {
				   lastname=req.getParameter("lastnameworker");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<workers.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&(!workers.get(i).getLastName().equalsIgnoreCase(lastname)))
			{workers.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&(workers.get(i).getLastName().compareToIgnoreCase(lastname)<0)) 
			{workers.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&(workers.get(i).getLastName().compareToIgnoreCase(lastname)>0))
			{workers.remove(i);i--;}
				   }				  
			   }
			   
			   if(req.getParameter("dataOfBirth")!=null&&(!req.getParameter("dataOfBirth").equalsIgnoreCase(""))) {
				   String dataOfBirth="";
				   try {
					   dataOfBirth=req.getParameter("dataOfBirth");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<workers.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&(!workers.get(i).getBirth().equalsIgnoreCase(dataOfBirth)))
			{workers.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&(workers.get(i).getBirth().compareToIgnoreCase(dataOfBirth)<0)) 
			{workers.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&(workers.get(i).getBirth().compareToIgnoreCase(dataOfBirth)>0))
			{workers.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("positionworker")!=null&&(!req.getParameter("positionworker").equalsIgnoreCase(""))) {
				   String positionworker="";
				   try {
					   positionworker=req.getParameter("positionworker");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<workers.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&(!workers.get(i).getPosition().getName().equalsIgnoreCase(positionworker)))
			{workers.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&(workers.get(i).getPosition().getName().compareToIgnoreCase(positionworker)<0)) 
			{workers.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&(workers.get(i).getPosition().getName().compareToIgnoreCase(positionworker)>0))
			{workers.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("departamentworker")!=null&&(!req.getParameter("departamentworker").equalsIgnoreCase(""))) {
				   String departamentworker="";
				   try {
				   departamentworker=req.getParameter("departamentworker");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<workers.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&
					(!workers.get(i).getDepartament().getNameDep().equalsIgnoreCase(departamentworker)))
			{workers.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&
					(workers.get(i).getDepartament().getNameDep().compareToIgnoreCase(departamentworker)<0)) 
			{workers.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&
					(workers.get(i).getDepartament().getNameDep().compareToIgnoreCase(departamentworker)>0))
			{workers.remove(i);i--;}
				   }				  
			   }
			   
			   req.setAttribute("outwork", workers);
		   }
		   try {
			getServletContext().getRequestDispatcher("/web/Employees.jsp").forward(req, resp);
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
