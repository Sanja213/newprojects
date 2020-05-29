package factory.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Worker.Worker;
import Worker.action.CheckWorker;
import Worker.action.ChooseWorker;
import factory.db.ManageSystem;




@WebServlet("/delworker")
public class DelWorkerServlet extends HttpServlet{
	private static final long serialVersionUID = -307316298424980469L;
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8"); 
		   ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Worker> list=manageSystem.getAllWorkers();
		   req.setAttribute("workers", list);	
		 
		 if(req.getParameter("enter")!=null) {
		 if((req.getParameter("nameworker").equals(""))&&(req.getParameter("id").equals(""))) {
			
			 try {
				getServletContext().getRequestDispatcher("/web/DelEmp.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
		 }else {ArrayList<Worker> workers=new ArrayList<>();
		if((!req.getParameter("nameworker").equals(""))&&CheckWorker.checkFullName(req)) {	
			 {			 		 		   
	         Worker wor=ChooseWorker.chooseWorkerFull(req);
			 workers.add(wor);
			 manageSystem.delWorker(wor);
			 req.setAttribute("outwork", workers); 
		}
		}
		if((!req.getParameter("id").equals(""))&&CheckWorker.checkId(req)) {	 
		  {			 		 		   
		 Worker wor=ChooseWorker.chooseWorkerId(req);
		 workers.add(wor);
		 manageSystem.delWorker(wor);
		 req.setAttribute("outwork", workers);
	}
	}
		
		 } 
	 }
		 list=manageSystem.getAllWorkers();
		   req.setAttribute("workers", list);
		 try {
     getServletContext().getRequestDispatcher("/web/DelEmp.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
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
