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
import factory.departament.action.CheckDepartament;
import factory.departament.action.ChooseDep;
import factory.position.Position;
import factory.position.action.CheckPosition;
import factory.position.action.ChoosePos;

@WebServlet("/adddepartament")
public class AddDepServlet extends HttpServlet{
	private static final long serialVersionUID = -5990841899924390220L;
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		                                                              		 
		 if(req.getParameter("enter")!=null) {
			 ManageSystem manageSystem=ManageSystem.getInstance();       		 
		 if((req.getParameter("namedep").equals(""))) {
				                                                           	 
			 try {
				getServletContext().getRequestDispatcher("/web/AddDep.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
		 }else {                                                              		 
		if(!CheckDepartament.checkName(req)) {	                                	 
			 String name = req.getParameter("namedep");
			 Departament departament=new Departament();
			 departament.setNameDep(name);
			 manageSystem.createDepartament(departament);
		   
			 Departament dep=ChooseDep.chooseDep(req);
			 ArrayList<Departament> departaments=new ArrayList<>();
			 departaments.add(dep);
			 req.setAttribute("outdep", departaments);
		}
		}
		 
		 try {
        getServletContext().getRequestDispatcher("/web/AddDep.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		 } 
	 }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest( req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest( req, resp);
	}

	
}
