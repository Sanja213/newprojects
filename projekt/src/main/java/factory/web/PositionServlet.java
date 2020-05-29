package factory.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.db.ManageSystem;
import factory.position.Position;
@WebServlet("/position")
public class PositionServlet extends HttpServlet{
	private static final long serialVersionUID = -2186147201717048329L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		  req.setCharacterEncoding("UTF-8"); 
		   ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Position> list=manageSystem.getAllPositions();
		   req.setAttribute("positions", list);
		   
		   if(req.getParameter("enter")!=null) {
			   ArrayList<Position> positions =new ArrayList<>();
			   positions.addAll(list);
			   if(req.getParameter("iddep")!=null&&(!req.getParameter("iddep").equalsIgnoreCase(""))) {
				   int id=-1;
				   try {
				   id=Integer.parseInt(req.getParameter("iddep"));}
				   catch(NumberFormatException e) {e.printStackTrace();}
				     for(int i=0;i<positions.size();i++) {
					   if((req.getParameter("rad").equals("equally"))&&(positions.get(i).getId()!=id)) {positions.remove(i);i--;}
					   if((req.getParameter("rad").equals("more"))&&(positions.get(i).getId()<id)) {positions.remove(i);i--;}
					   if((req.getParameter("rad").equals("less"))&&(positions.get(i).getId()>id)) {positions.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("namedep")!=null&&(!req.getParameter("namedep").equalsIgnoreCase(""))) {
				   String name="";
				   try {
				   name=req.getParameter("namedep");}
				   catch(NullPointerException e) {e.printStackTrace();}
				   for(int i=0;i<positions.size();i++) {
			if((req.getParameter("rad").equals("equally"))&&(!positions.get(i).getName().equalsIgnoreCase(name)))
			{positions.remove(i);i--;}
			if((req.getParameter("rad").equals("more"))&&(positions.get(i).getName().compareToIgnoreCase(name)<0)) 
			{positions.remove(i);i--;};
			if((req.getParameter("rad").equals("less"))&&(positions.get(i).getName().compareToIgnoreCase(name)>0))
			{positions.remove(i);i--;}
				   }				  
			   }
			   if(req.getParameter("tarif")!=null&&(!req.getParameter("tarif").equalsIgnoreCase(""))) {
				   double tarif=-1;
				   try {
				   tarif=Double.parseDouble(req.getParameter("tarif"));}
				   catch(NumberFormatException e) {e.printStackTrace();}
				   for(int i=0;i<positions.size();i++) {
					   if((req.getParameter("rad").equals("equally"))&&(positions.get(i).getTarif()!=tarif))
					   {positions.remove(i);i--;}
					   if((req.getParameter("rad").equals("more"))&&(positions.get(i).getTarif()<tarif))
					   {positions.remove(i);i--;}
					   if((req.getParameter("rad").equals("less"))&&(positions.get(i).getTarif()>tarif))
					   {positions.remove(i);i--;}
				   }				  
			   }
			   req.setAttribute("posout", positions);
		   }
		   try {
			getServletContext().getRequestDispatcher("/web/Positions.jsp").forward(req, resp);
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
