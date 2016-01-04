package m2geii.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet 
{	
	private static final long serialVersionUID = -4312652067101625925L;
	
	public static final String VIEW_MAIN = "/WEB-INF/main.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		this.getServletContext().getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		this.getServletContext().getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}
}
