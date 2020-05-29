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
import factory.position.action.ChoosePos;

@WebServlet("/changepos")
public class ChangePosServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5936837502544861547L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		 ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Position> list=manageSystem.getAllPositions();
		   req.setAttribute("positions", list);   
		  	 
		 if((req.getParameter("enter")!=null)&&(!req.getParameter("iddep").equalsIgnoreCase(""))&&
				 (!req.getParameter("namedep").equalsIgnoreCase(""))) {
			 ArrayList<Position> positions = new ArrayList<>();
			 Position newpos=new Position();
			 Position oldpos = new Position();    
			 
			 if(!req.getParameter("iddep").equalsIgnoreCase("")) {     
				  	 oldpos=ChoosePos.choosePosId(req);
					 newpos=ChoosePos.choosePosId(req);
					 if(!req.getParameter("namedep").equalsIgnoreCase("")) {   
						 newpos.setName(req.getParameter("namedep"));
					 }	 
					 if(!req.getParameter("tarif").equalsIgnoreCase("")) { 
						 double tarif=-1;
						 try {
							 tarif=Double.parseDouble(req.getParameter("tarif"));
						 }catch(NumberFormatException e) {e.printStackTrace();}
						 if(tarif>=0) newpos.setTarif(tarif);
					 }
					 
				 
			 }else {                                                            
				 if(!req.getParameter("namedep").equalsIgnoreCase("")) {        
					 oldpos=ChoosePos.choosePos(req);
					 newpos=ChoosePos.choosePos(req);
					 if(!req.getParameter("tarif").equalsIgnoreCase("")) {        
						 double tarif=-1;
						 try {
							 tarif=Double.parseDouble(req.getParameter("tarif"));
						 }catch(NumberFormatException e) {e.printStackTrace();}
						 if(tarif>=0) newpos.setTarif(tarif);
					 
				 }
			 }
		 }
			manageSystem.updatePosition(newpos);
			 positions.add(oldpos);
			 positions.add(newpos);
			 req.setAttribute("changepos", positions);                                    
				 
		 }
		 try {                                                                          
				getServletContext().getRequestDispatcher("/web/ChengePos.jsp").forward(req, resp);
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
