package m2geii.forum.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

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
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	int status = -1;
    	
    	//execution
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("INSERT INTO users (login, pass, firstname, secondname) VALUES (?, ?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			//attributes
			stat.setString(1, user.getLogin());
			stat.setString(2, user.getPass());
			stat.setString(3, user.getFirstname());
			stat.setString(4, user.getSecondname());
			
			//execution
			status = stat.executeUpdate();
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
