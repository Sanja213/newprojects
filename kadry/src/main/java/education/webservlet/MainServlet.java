package education.webservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/work")
public class MainServlet extends HttpServlet{

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
	//	 getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
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