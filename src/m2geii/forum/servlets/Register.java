package m2geii.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Une servlet qui charge
 * la vue register.jsp
 * 
 * @author Ganza Mykhailo
 */
public class Register extends HttpServlet 
{	
	private static final long serialVersionUID = 4373874692137096820L;

	public static final String VIEW_REGISTER = "/WEB-INF/register.jsp";
	
	/**
	 * Charge la vue register.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		this.getServletContext().getRequestDispatcher(VIEW_REGISTER).forward(request, response);
	}
}
