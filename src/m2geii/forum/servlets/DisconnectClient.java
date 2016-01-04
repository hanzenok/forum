package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisconnectClient extends HttpServlet 
{	
	private static final long serialVersionUID = 8226842651166524768L;
	
	public static final String VIEW_INDEX = "/WEB-INF/index.jsp";

	public static final String ATT_USER = "user";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.removeAttribute(ATT_USER);
		
		this.getServletContext().getRequestDispatcher(VIEW_INDEX).forward(request, response);
	}

}
