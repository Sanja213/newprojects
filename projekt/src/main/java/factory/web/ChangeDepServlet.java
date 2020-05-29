package factory.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.db.ManageSystem;
import factory.departament.Departament;
import factory.departament.action.ChooseDep;
import factory.position.action.ChoosePos;

@WebServlet("/changedep")
public class ChangeDepServlet extends HttpServlet{
	private static final long serialVersionUID = -9000256621910816809L;
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		 ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Departament> list=manageSystem.getAllDepartaments();
		   req.setAttribute("departaments", list);   
		  	 
		 if((req.getParameter("enter")!=null)&&(!req.getParameter("iddep").equalsIgnoreCase(""))&&
				 (!req.getParameter("namedep").equalsIgnoreCase(""))) {
			 ArrayList<Departament> departaments = new ArrayList<>();
			 Departament newdep=new Departament();
			 Departament olddep = new Departament();    
			 
			 if(!req.getParameter("iddep").equalsIgnoreCase("")) {     
				  	 olddep=ChooseDep.chooseDepId(req);
					 newdep=ChooseDep.chooseDepId(req);
					 if(!req.getParameter("namedep").equalsIgnoreCase("")) {   
						 newdep.setNameDep(req.getParameter("namedep"));
					 }						 			 
				 
			 }else {                                                            

		 }
			manageSystem.updateDepartament(newdep);
			 departaments.add(olddep);
			 departaments.add(newdep);
			 req.setAttribute("changedep", departaments);                                    
				 
		 }
		 try {                                                                          
				getServletContext().getRequestDispatcher("/web/ChengeDep.jsp").forward(req, resp);
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
