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
 * un nouveau utilisteur dans la bd
 * et le charge dans la session
 * 
 * @author Ganz Mykhilo
 */
public class AddUser extends HttpServlet {
	
	private static final long serialVersionUID = 4373874692137096820L;

	public static final String VIEW_REGISTER = "/WEB-INF/register.jsp";
	public static final String SERVLET_MAIN = "/forum/main";
	
	public static final String FIELD_LOGIN = "login";
	public static final String FIELD_PASS1 = "password";
	public static final String FIELD_PASS2 = "password2";
	public static final String FIELD_FNAME = "firstname";
	public static final String FIELD_SNAME = "secondname";
	
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_USER = "user";

	/**
	 * Ajoute
	 * un nouveau utilisteur dans la bd
	 * et le charge dans la session
	 * Repond à un clique sur un bouton
	 * "ajouter" utilisateur
	 */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
    	//reccuperation des parametres
    	String login = request.getParameter(FIELD_LOGIN);
    	String pass1 = request.getParameter(FIELD_PASS1);
    	String pass2 = request.getParameter(FIELD_PASS2);
    	String firstname = request.getParameter(FIELD_FNAME);
    	String secondname = request.getParameter(FIELD_SNAME);
    	
    	//verification des mot de passes
    	String message = "";
    	if(!pass1.equals(pass2))
    	{
    		message = "Les mots de passes ne correspondent pas";
    		
        	request.setAttribute(ATT_MESSAGE, message);  	
        	this.getServletContext().getRequestDispatcher(VIEW_REGISTER).forward(request, response);
        	
        	return;
    	}

    	//creation de user bean
    	User user = new User();
    	user.setLogin(login);
    	user.setFirstname(firstname);
    	user.setSecondname(secondname);
    	
    	//ajout dans la bd
    	ForumDB db = new ForumDB();
    	int status = db.addUser(user, pass1);
    	
    	if(status == -1)
    	{
    		message = "Utilisateur avec cet login '" + user.getLogin() + "' existe déjà";
    		
        	request.setAttribute(ATT_MESSAGE, message);  	
        	this.getServletContext().getRequestDispatcher(VIEW_REGISTER).forward(request, response);
        	
        	return;
    	}
    	
    	//redirection vers la page principale
    	HttpSession session = request.getSession();
    	session.setAttribute(ATT_USER, user);
    	
    	response.sendRedirect(SERVLET_MAIN);
    		
    }
}
