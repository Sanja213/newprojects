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


@WebServlet("/departaments")
public class DepartamentServlet extends HttpServlet{
	private static final long serialVersionUID = 1563275002590358882L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		  req.setCharacterEncoding("UTF-8"); 
		   ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Departament> list=manageSystem.getAllDepartaments();
		   req.setAttribute("departaments", list);
		   
		   if(req.getParameter("enter")!=null) {
			   ArrayList<Departament> departaments =new ArrayList<>();
			   departaments.addAll(list);
			   if(req.getParameter("iddep")!=null&&(!req.getParameter("iddep").equalsIgnoreCase(""))) {
				   int id=-1;
				   try {
				   id=Integer.parseInt(req.getParameter("iddep"));}
				   catch(NumberFormatException e) {e.printStackTrace();}
				     for(int i=0;i<departaments.size();i++) {
					   if((req.getParameter("rad").equals("equally"))&&(departaments.get(i).getIdDep()!=id)) {departaments.remove(i);i--;}
					   if((req.getParameter("rad").equals("more"))&&(departaments.get(i).getIdDep()<id)) {departaments.remove(i);i--;}
					   if((req.getParameter("rad").equals("less"))&&(departaments.get(i).getIdDep()>id)) {departaments.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("namedep")!=null&&(!req.getParameter("namedep").equalsIgnoreCase(""))) {
				   String name="";
				   try {
				   name=req.getParameter("namedep");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<departaments.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&(!departaments.get(i).getNameDep().equalsIgnoreCase(name)))
			{departaments.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&(departaments.get(i).getNameDep().compareToIgnoreCase(name)<0)) 
			{departaments.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&(departaments.get(i).getNameDep().compareToIgnoreCase(name)>0))
			{departaments.remove(i);i--;}
				   }				  
			   }
			  
			   req.setAttribute("depout", departaments);
		   }
		   try {
			getServletContext().getRequestDispatcher("/web/Departaments.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	 
}
