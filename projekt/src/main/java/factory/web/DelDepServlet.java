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
import factory.position.action.CheckName;
import factory.position.action.ChoosePos;

@WebServlet("/deldepartament")
public class DelDepServlet extends HttpServlet{
	private static final long serialVersionUID = -11871929848028918L;
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		   ManageSystem manageSystem=ManageSystem.getInstance();
	
		 
		 if(req.getParameter("enter")!=null) {
		 if((req.getParameter("namedep").equals(""))&&(req.getParameter("iddep").equals(""))) {
			
			 try {
				getServletContext().getRequestDispatcher("/web/DelDep.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
		 }else {ArrayList<Departament> departaments=new ArrayList<>();
		if((!req.getParameter("namedep").equals(""))&&CheckDepartament.checkName(req)) {	
			 {			 		 		   
			 Departament dep=ChooseDep.chooseDep(req);
			 departaments.add(dep);
			 manageSystem.delDepartament(dep);
			 req.setAttribute("departaments", departaments); 
		}
		}
		if((!req.getParameter("iddep").equals(""))&&CheckDepartament.checkId(req)) {	 
		  {			 		 		   
		 Departament dep=ChooseDep.chooseDepId(req);
		 departaments.add(dep);
		 manageSystem.delDepartament(dep);
		 req.setAttribute("departaments", departaments);
	}
	}
		 
		 try {
       getServletContext().getRequestDispatcher("/web/DelDep.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		 } 
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
