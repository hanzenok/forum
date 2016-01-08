package m2geii.forum.beans;

/**
 * Un bean qui répresente
 * une message laissée par 
 * utilisateur
 * 
 * @author Ganza Mykhailo
 */
public class Post {

	private int id; //l'identifiant de post dans la bd
	
	private User author; //créator de post
	private String date; //date de créations
	private String text; //le message
	
	/**
	 * Renvoi l'id de bd de post
	 * @return id de post
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * Définit l'id de bd de post
	 * @param id id de post
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * Renvoit le créateur
	 * de post
	 * @return créateur de post
	 */
	public User getAuthor() 
	{
		return author;
	}
	
	/**
	 * Défini le créateur de post
	 * @param author créateur 
	 */
	public void setAuthor(User author) 
	{
		this.author = author;
	}
	
	/**
	 * Renvoit la date 
	 * de création de post
	 * @return
	 */
	public String getDate() 
	{
		return date;
	}
	
	/**
	 * Défini la date 
	 * de création de post
	 * @param date date de création
	 */
	public void setDate(String date) 
	{
		this.date = date;
	}
	
	/**
	 * Renvoit le message de post
	 * @return message
	 */
	public String getText() 
	{
		return text;
	}
	
	/**
	 * Défini le messge de post
	 * @param text message de post
	 */
	public void setText(String text) 
	{
		this.text = text;
	}
	
}
