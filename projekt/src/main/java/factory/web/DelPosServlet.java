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
import factory.position.action.CheckName;
import factory.position.action.CheckPosition;
import factory.position.action.ChoosePos;
@WebServlet("/delposition")
public class DelPosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8645870053888428506L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		   ManageSystem manageSystem=ManageSystem.getInstance();
	
		 
		 if(req.getParameter("enter")!=null) {
		 if((req.getParameter("namedep").equals(""))&&(req.getParameter("iddep").equals(""))) {
			
			 try {
				getServletContext().getRequestDispatcher("/web/DelPos.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
		 }else {ArrayList<Position> positions=new ArrayList<>();
		if((!req.getParameter("namedep").equals(""))&&CheckName.checkName(req)) {	
			 {			 		 		   
			 Position pos=ChoosePos.choosePos(req);
			 positions.add(pos);
			 manageSystem.delPosition(pos);
			 req.setAttribute("positions", positions); 
		}
		}
		if((!req.getParameter("iddep").equals(""))&&CheckName.checkId(req)) {	 
		  {			 		 		   
		 Position pos=ChoosePos.choosePosId(req);
		 positions.add(pos);
		 manageSystem.delPosition(pos);
		 req.setAttribute("positions", positions);
	}
	}
		 
		 try {
        getServletContext().getRequestDispatcher("/web/DelPos.jsp").forward(req, resp);
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
