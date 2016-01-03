package m2geii.forum.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import m2geii.forum.beans.User;

public class ForumDB 
{
	private final String BD_URL = "jdbc:mysql://localhost:3306/forum";
	private final String BD_USER = "root";
	private final String BD_PASS = "svessa";
	
	public ForumDB()
	{
    	//chargement de driver jdbc
    	try {Class.forName("com.mysql.jdbc.Driver");} 
    	catch ( ClassNotFoundException e ) {e.printStackTrace();}
	}
	
	public int addUser(User user)
	{	
    	Connection conn = null;
    	Statement stat = null;
    	ResultSet result = null;
    	int status = -1;
    	
    	//execution
    	try 
    	{
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			stat = conn.createStatement();
			
			status = stat.executeUpdate("INSERT INTO users (login, pass, firstname, secondname) "
					+ "VALUES ('" + user.getLogin() + "', '" + user.getPass() + "', '" + user.getFirstname() +
					"', '" + user.getSecondname() + "');" , Statement.RETURN_GENERATED_KEYS);
    	} 
    	catch (SQLException e) {e.printStackTrace();}
		
    	//reccuperer l'id generee
    	if(status != -1)
    	{
    		try 
    		{
    			//l'id
    			result = stat.getGeneratedKeys();
    			
    			//ajout
    			while(result.next())
    				user.setId(result.getLong(1));
    		} 
    		catch (SQLException e) {e.printStackTrace();}
    	}
    	
		return status;
	}
}
