package education.webservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import education.worker.AddWorker;
import education.worker.ChengeDep;
import education.worker.ChengePosition;
import education.worker.DelWorker;
import education.worker.ListWorkers;
import education.worker.Worker;
import education.worker.worceraction.ChekAction;
import education.worker.worceraction.WorkAddList;
@WebServlet("/workers")
public class WorkServlet extends HttpServlet{
	protected  void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ArrayList<Worker> list1=new ArrayList<Worker>();
		 int answer = 0;	      
	      try {
			answer = ChekAction.checkAction(req);
			} catch (SQLException e) {
			
			e.printStackTrace();
		}   
	 //  System.out.println();
	        if (answer==1) {
	        	if((!req.getParameter("number").equals(""))&&(!req.getParameter("name").equals(""))
	        			&&(!req.getParameter("patronomic").equals(""))&&(!req.getParameter("lastname").equals(""))&&
	        			(!req.getParameter("dateofbirth").equals(""))){
	            		
	        		AddWorker.addWorker(req,ListWorkers.workers );
	        }
	        }
	    	
   	        
	        if (answer==2 ) {
	        	if((!req.getParameter("number").equals(""))){
	            		
	        	DelWorker.delWorker(ListWorkers.workers, req);
	        }
	        	} 
	        if (answer==3 ) {                	
	        	ChengeDep.chengeDep(ListWorkers.workers, req);
	        	       	
	        	
	        }
           if (answer==4 ) {                	
        	   ChengePosition.chengePosition(ListWorkers.workers, req);
	        	       	
	        	
	        }
	     //   int form=Integer.parseInt((String)req.getParameter("number"));
	        req.setAttribute("form", list1);
	        getServletContext().getRequestDispatcher("/web/worker.jsp").forward(req, resp); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest( req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest( req,  resp);
	}

}
