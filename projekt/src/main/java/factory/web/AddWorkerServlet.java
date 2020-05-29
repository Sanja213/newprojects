package factory.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Worker.Worker;
import Worker.action.CheckWorker;
import Worker.action.ChooseWorker;
import factory.db.ManageSystem;
import factory.departament.Departament;
import factory.departament.action.ChooseDep;
import factory.position.Position;
import factory.position.action.ChoosePos;

@WebServlet("/addworker")
public class AddWorkerServlet extends HttpServlet {
	private static final long serialVersionUID = -3350415406755693036L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 req.setCharacterEncoding("UTF-8");
		 ManageSystem manageSystem=ManageSystem.getInstance();
		   ArrayList<Departament> list=manageSystem.getAllDepartaments();
		   req.setAttribute("departaments", list);
		   
		   ArrayList<Position> list1=manageSystem.getAllPositions();
		   req.setAttribute("positions", list1);
		  		 
		 if(req.getParameter("enter")!=null) {
			 if((req.getParameter("name").equals(""))||(req.getParameter("lastname").equals(""))||
				 (req.getParameter("dateofbirth").equals(""))||(req.getParameter("namepos").equals(""))||
				 (req.getParameter("depname").equals(""))) {
			
			 try {
				getServletContext().getRequestDispatcher("/web/AddEmp.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
		 }else {
		if(!CheckWorker.checkName(req)) {	 
			 String name = req.getParameter("name");
			 String lastName = req.getParameter("lastname");
			 
			  Date dateOfBirth = new Date();
			 
			 try {
				String date=req.getParameter("dateofbirth");
				String[] date1=date.split("\\W");
				if(date1[0].length()==4) date=date1[2]+"."+date1[1]+"."+date1[0];
				else date=date1[0]+"."+date1[1]+"."+date1[2];
				SimpleDateFormat old=new SimpleDateFormat("dd.MM.yyyy");
					dateOfBirth= old.parse(date); 
						} catch (ParseException e) {
						e.printStackTrace();
				}
			
				
			 
			 Position position = ChoosePos.choosePos(req);
			 Departament departament =ChooseDep.chooseDep(req);
			 
			 Worker worker=new Worker();
			 worker.setName(name);
			 worker.setLastName(lastName);
			 worker.setDateOfBirth(dateOfBirth);
			 worker.setPosition(position);
			 worker.setDepartament(departament);
			 		 
			 manageSystem.createWorker(worker);
		   
			 Worker wr=ChooseWorker.chooseWorker(req);
			 ArrayList<Worker> workers=new ArrayList<>(); 
			 workers.add(wr);
			 req.setAttribute("outwork", workers);
		
		}
		 
		
		 } 
	 }
		 try {
		        getServletContext().getRequestDispatcher("/web/AddEmp.jsp").forward(req, resp);
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
