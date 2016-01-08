package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Une servlet qui
 * vide la session et y supprime
 * le bean Conversations et bean
 * User
 * 
 * @author Ganza Mykhailo
 */
public class DisconnectClient extends HttpServlet 
{	
	private static final long serialVersionUID = 8226842651166524768L;
	
	public static final String SERVLET_INDEX = "/forum/index";

	public static final String ATT_USER = "user";
	public static final String ATT_CONVS = "conversations";
	
	/**
	 * Supprime un bean Conversations
	 * et User de la session
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//session
		HttpSession session = request.getSession();
		
		//suppression des attribus
		session.removeAttribute(ATT_USER);
		session.removeAttribute(ATT_CONVS);
		
		//redirection vers la page d'acceuil
		response.sendRedirect(SERVLET_INDEX);
	}

}
