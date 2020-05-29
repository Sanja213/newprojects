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
import factory.position.action.CheckPosition;
import factory.position.action.ChoosePos;
@WebServlet("/addposition")
public class AddPosServlet extends HttpServlet{

	private static final long serialVersionUID = 4786306067711277332L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		  		 
		 if(req.getParameter("enter")!=null) {
			 ManageSystem manageSystem=ManageSystem.getInstance();
		 if((req.getParameter("namedep").equals(""))||(req.getParameter("tarif").equals(""))) {
			
			 try {
				getServletContext().getRequestDispatcher("/web/AddPos.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
		 }else {
		if(CheckPosition.checkPosition(req)) {	 
			 String name = req.getParameter("namedep");
			 double tarif=-1.0;
			 try {
			 tarif = Double.parseDouble(req.getParameter("tarif"));} catch(NumberFormatException e) {e.printStackTrace();}
			if(tarif>=0) {
			 Position position=new Position();
			 position.setName(name);
			 position.setTarif(tarif);
			 manageSystem.createGroup(position);
		   
			 Position pos=ChoosePos.choosePos(req);
			 ArrayList<Position> positions=new ArrayList<>();
			 positions.add(pos);
			 req.setAttribute("news", positions);
		}
		}
		 
		 try {
         getServletContext().getRequestDispatcher("/web/AddPos.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
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
