package m2geii.forum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateClient extends HttpServlet {
	
	private static final long serialVersionUID = 4373874692137096820L;

	public static final String VIEW = "/WEB-INF/register.jsp";
	public static final String FIELD_LOGIN = "login";
	public static final String FIELD_PASS1 = "password";
	public static final String FIELD_PASS2 = "password2";
	public static final String FIELD_FNAME = "firstname";
	public static final String FIELD_SNAME = "secondname";
	public static final String ATT_MESSAGE = "message";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
    	//reccuperation des parametres
    	String login = request.getParameter(FIELD_LOGIN);
    	String pass1 = request.getParameter(FIELD_PASS1);
    	String pass2 = request.getParameter(FIELD_PASS2);
    	String firstname = request.getParameter(FIELD_FNAME);
    	String secondname = request.getParameter(FIELD_SNAME);
    	
    	//chargement de driver jdbc
    	try {Class.forName("com.mysql.jdbc.Driver");} 
    	catch ( ClassNotFoundException e ) {e.printStackTrace();}
    	
    	//connexion a la base
    	String url = "jdbc:mysql://localhost:3306/forum";
    	String user = "root";
    	String bdpass = "svessa";
    	Connection conn = null;
    	Statement stat = null;
    	int status = -1;
    	
    	try 
    	{
			conn = DriverManager.getConnection(url, user, bdpass);	
			stat = conn.createStatement();
			status = stat.executeUpdate("INSERT INTO users (login, pass, firstname, secondname) "
					+ "VALUES ('" + login + "', '" + pass1 + "', '" + firstname + "', '" + secondname + "');" 
					, Statement.RETURN_GENERATED_KEYS);
    	} 
    	
    	
    	catch (SQLException e) {e.printStackTrace();}
    	//message
    	String message = new String();
    	if(!pass1.equals(pass2)) message = "Les mot de passes ne correspondent pas";
    	
    	message += "(" + status + ")";
    	request.setAttribute(ATT_MESSAGE, message);
    	this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    
    }
}
