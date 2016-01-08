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
 * Une servlet d'accueil de site
 * Gère la vue index.jsp
 * 
 * @author Ganza Mykhailo
 */
public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 7098976741262951870L;
	
	public static final String VIEW_INDEX = "/WEB-INF/index.jsp";
	public static final String SERVLET_MAIN = "/forum/main";
	
	public static final String FIELD_LOGIN = "login";
	public static final String FIELD_PASS = "password";
	
	public static final String ATT_USER = "user";
	public static final String ATT_MESSAGE = "message";
	
	/**
	 * Charge la vue index.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//charge la page
		this.getServletContext().getRequestDispatcher(VIEW_INDEX).forward(request, response);
	}
	
	/**
	 * Repond à un clique sur le button "connexion"
	 * Charge le bean User dans la session
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//reccuperation des parametres
		String login = request.getParameter(FIELD_LOGIN);
		String pass = request.getParameter(FIELD_PASS);
    	
    	//reccuperation de user bean de la bd
    	ForumDB db = new ForumDB();
    	User user = db.checkUser(login, pass);
		
		String message = "";
		if(user == null)
		{
    		message = "Erreur";
    		
    		//rechargemment de la page
        	request.setAttribute(ATT_MESSAGE, message);  	
        	this.getServletContext().getRequestDispatcher(VIEW_INDEX).forward(request, response);
		}
		else
		{
	    	HttpSession session = request.getSession();
	    	session.removeAttribute(ATT_USER);//suppression de toute compte
	    	//si on est sur la page d'acceuil
	    	
	    	//verification si l'utilisateur est deja connectee
	    	User check_user = (User) session.getAttribute(ATT_USER);
	    	if(check_user != null)
	    	{
	    		message = "Erreur";
	    		
	    		//rechargemment de la page
	        	request.setAttribute(ATT_MESSAGE, message);  	
	        	this.getServletContext().getRequestDispatcher(VIEW_INDEX).forward(request, response);
	    	}
	    	
	    	session.setAttribute(ATT_USER, user);
	    	
	    	//redirection vers la page principale
	    	response.sendRedirect(SERVLET_MAIN);
		}
	}


}
