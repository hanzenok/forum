package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.ForumDB;
import m2geii.forum.beans.User;

/**
 * Une servlet qui ajoute
 * une nouvelle conversation dans
 * la bd et l'ajout dans le bean
 * Conversations de session
 * 
 * @author Ganza Mykhailo
 */
public class CreateConversation extends HttpServlet 
{
	private static final long serialVersionUID = -7698256495601904630L;
	
	public static final String SERVLET_MAIN = "/forum/main";
	public static final String FIELD_TITLE = "title";
	public static final String ATT_USER = "user";

	
	/**
	 * Ajoute une nouvelle conversation dans
     * la bd et l'ajout dans le bean
     * Conversations de session
     * Repond à un cliquer sur button
     * "ajouter" (conversation)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//reccuperation des parametres
		String title = request.getParameter(FIELD_TITLE);
		
		if (!title.equals(""))
		{
			//reccuperation de user actuel
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(ATT_USER);
			
			//ajout dans la bd
			ForumDB bd = new ForumDB();
			bd.createConversation(user, title);
		}
		
		//rediriger vers la page principale
		response.sendRedirect(SERVLET_MAIN);
	}

}
