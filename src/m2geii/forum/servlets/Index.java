package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.ForumDB;
import m2geii.forum.beans.User;

public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 7098976741262951870L;
	
	public static final String VIEW_INDEX = "/WEB-INF/index.jsp";
	public static final String SERVLET_CONVERSATIONS = "/forum/conversations";
	
	public static final String FIELD_LOGIN = "login";
	public static final String FIELD_PASS = "password";
	
	public static final String ATT_USER = "user";
	public static final String ATT_MESSAGE = "message";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//charge la page
		this.getServletContext().getRequestDispatcher(VIEW_INDEX).forward(request, response);
	}
	
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
    		message = "Login ou mot de passe incorrect";
    		
        	request.setAttribute(ATT_MESSAGE, message);  	
        	this.getServletContext().getRequestDispatcher(VIEW_INDEX).forward(request, response);
		}
		else
		{
			//redirection vers la page principale
	    	HttpSession session = request.getSession();
	    	session.setAttribute(ATT_USER, user);
	    	
	    	response.sendRedirect(SERVLET_CONVERSATIONS);
		}
	}


}
