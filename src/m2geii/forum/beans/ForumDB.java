package m2geii.forum.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    	
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("INSERT INTO users (login, pass, firstname, secondname) VALUES (?, ?, ?, ?);"
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
    			result.next();
    			user.setId(result.getInt(1));
    		} 
    		catch (SQLException e) {e.printStackTrace();}
    	}
    	
    	//cloture de connexion
    	
		try 
		{
			if(conn != null) conn.close();
			if(stat != null) stat.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
    	
		return status;
	}
	
	public User checkUser(String login, String pass)
	{
    	Connection conn = null;
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	User user = null;
    	
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("SELECT * FROM users WHERE login = ? AND pass = ?;");
			
			//attributes
			stat.setString(1, login);
			stat.setString(2, pass);
			
			//execution
			result = stat.executeQuery();
			result.next();
			
			//si il y a plusieur ou aucune ligne
			if(result.getRow() != 1) 
				return null;
			
	    	//creation de user bean
	    	user = new User();
	    	user.setId(result.getInt(1));
	    	user.setLogin(login);
	    	user.setPass(pass);
	    	user.setFirstname(result.getString(4));
	    	user.setSecondname(result.getString(5));
	    	
	    	//cloture de connexion
	    	if(conn != null) conn.close();
	    	if(stat != null) stat.close();
	 
    	} 
    	catch (SQLException e) {e.printStackTrace();}

    	return user;
	}
	
	//pas de mdp
	public User getUser(String login)
	{
    	Connection conn = null;
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	User user = null;
    	
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("SELECT * FROM users WHERE login = ?;");
			
			//attributes
			stat.setString(1, login);
			
			//execution
			result = stat.executeQuery();
			result.next();
			
			//si il y a plusieur ou aucune ligne
			if(result.getRow() != 1) 
				return null;
			
	    	//creation de user bean
	    	user = new User();
	    	user.setId(result.getInt(1));
	    	user.setLogin(login);
	    	user.setFirstname(result.getString(4));
	    	user.setSecondname(result.getString(5));
	    	
	    	//cloture de connexion
	    	if(conn != null) conn.close();
	    	if(stat != null) stat.close();
	 
    	} 
    	catch (SQLException e) {e.printStackTrace();}

    	return user;
	}	
	
	public Conversations getConversations()
	{	
    	Connection conn = null;
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	ArrayList<Conversation> conversations_list = null;
    	Conversations conversations = null;
		
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("SELECT * FROM conversations;");
			
			//execution
			result = stat.executeQuery();
			
			//reccuperation
			conversations_list = new ArrayList<Conversation>();
			while(result.next())
			{
				//creation de bean conversation
				Conversation conversation = new Conversation();
				conversation.setId(result.getInt(1));
				conversation.setAuthor(getUser(result.getString(2)));
				conversation.setTitle(result.getString(3));
				conversation.setCreationDate(result.getString(4));
				
				//reccuperation des post
				conversation.setPosts(getPosts(conversation.getId()));
				
				//ajout dans la liste
				conversations_list.add(conversation);
			}
			
	    	//cloture de connexion
	    	if(conn != null) conn.close();
	    	if(stat != null) stat.close();
	    	
	    	//creation de bean conversations
	    	conversations = new Conversations();
	    	conversations.setConversationsList(conversations_list);
	    	
    	} 
    	catch (SQLException e) {e.printStackTrace();}
    	
		return conversations;
	}
	
	public int createConversation(User user, String title)
	{
    	Connection conn = null;
    	PreparedStatement stat = null;
    	int status = -1;
    	
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("INSERT INTO conversations (author, title, creation_date)"
					+ " VALUES (?, ?, NOW());");
			
			//attributes
			stat.setString(1, user.getLogin());
			stat.setString(2, title);
			
			//execution
			status = stat.executeUpdate();
    	} 
    	catch (SQLException e) {e.printStackTrace();}
    	
    	//cloture de connexion
		try 
		{
			if(conn != null) conn.close();
			if(stat != null) stat.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
    	
		return status;
	}
	
	ArrayList<Post> getPosts(int id_conversation)
	{
    	Connection conn = null;
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	ArrayList<Post> posts = null;
		
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("SELECT * FROM posts WHERE id_conversation = ?;");
			
			//attributes
			stat.setInt(1, id_conversation);
			
			//execution
			result = stat.executeQuery();
			
			//reccuperation
			posts = new ArrayList<Post>();
			while(result.next())
			{
				//creation de bean post
				Post post = new Post();
				post.setId(result.getInt(1));
				post.setNumber(result.getInt(3));
				post.setAuthor(getUser(result.getString(4)));
				post.setDate(result.getString(5));
				post.setText(result.getString(6));
				
				//ajout dans la liste
				posts.add(post);
			}
			
	    	//cloture de connexion
	    	if(conn != null) conn.close();
	    	if(stat != null) stat.close();
    	} 
    	catch (SQLException e) {e.printStackTrace();}
    	
		return posts;
	}
	
	public int addPost(String author, int number, String text, int conversation_id)
	{
    	Connection conn = null;
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	int status = -1;
    	
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("INSERT INTO posts (id_conversation, number, author, date, text) VALUES (?, ?, ?, NOW(), ?);"
					, Statement.RETURN_GENERATED_KEYS);
			
			//attributes
			stat.setInt(1, conversation_id);
			stat.setInt(2, number);
			stat.setString(3,author);
			stat.setString(4, text);
			
			//execution
			status = stat.executeUpdate();
    	} 
    	catch (SQLException e) {e.printStackTrace();}
		
    	//reccuperer l'id generee
    	if(status != -1)
    	{
    		try 
    		{
    			//reccuperation de l'id
    			result = stat.getGeneratedKeys();
    			
    			result.next();
    			status = result.getInt(1);
    		} 
    		catch (SQLException e) {e.printStackTrace();}
    	}
    	
    	//cloture de connexion
    	
		try 
		{
			if(conn != null) conn.close();
			if(stat != null) stat.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
		
		return status;
	}
	
	public Post getPost(int post_id)
	{
    	Connection conn = null;
    	PreparedStatement stat = null;
    	ResultSet result = null;
    	Post post = null;
    	
    	//sql
    	try 
    	{
    		//connexion
			conn = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);	
			
			//requete preparee
			stat = conn.prepareStatement("SELECT * FROM posts WHERE id = ?;");
			
			//attributes
			stat.setInt(1, post_id);
			
			//execution
			result = stat.executeQuery();
			result.next();
			
			//si il y a plusieur ou aucune ligne
			if(result.getRow() != 1) 
				return null;
			
	    	//creation de user bean
	    	post = new Post();
	    	post.setId(result.getInt(1));
	    	post.setNumber(result.getInt(3));
	    	post.setDate(result.getString(5));
	    	post.setText(result.getString(6));
	    	
	    	//cloture de connexion
	    	if(conn != null) conn.close();
	    	if(stat != null) stat.close();
	 
    	} 
    	catch (SQLException e) {e.printStackTrace();}

    	return post;
	}
}
