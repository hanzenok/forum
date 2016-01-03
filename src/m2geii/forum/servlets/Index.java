package m2geii.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 7098976741262951870L;
	
	public static final String VIEW = "/WEB-INF/index.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}


}
