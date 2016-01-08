package m2geii.forum.beans;

import java.util.ArrayList;

/**
 * Un bean qui répresente
 * une conversation : 
 * un ensemble des posts(messages)
 * 
 * @author Ganza Mykhailo
 */
public class Conversation {
	
	private int id; //l'id de conversation dans la bd
	private User author; //créator de conversation
	private String title; //titre
	
	private String creation_date; //la date de créations
	
	private ArrayList<Post> posts; //ensemble des posts

	/**
	 * Renvoi l'id de bd de conversation
	 * @return id de conversation
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Défini l'id de bd de conversation
	 * @param id id de conversation
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Renvoi le créator de 
	 * conversation
	 * @return	User qui a crée une conversation
	 */
	public User getAuthor() 
	{
		return author;
	}

	/**
	 * Défini l'auter de la conversation
	 * @param author auteur de la conversation
	 */
	public void setAuthor(User author) 
	{
		this.author = author;
	}

	/**
	 * Renvoi le titre de la conversation
	 * @return titre de la conversation
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Défini le titre de la conversation
	 * @param title titre de la conversation
	 */
	public void setTitle(String title) 
	{
		this.title = title;
	}

	/**
	 * Renvoi la date de création
	 * de la conversation
	 * @return date de création de la conversation
	 */
	public String getCreationDate() 
	{
		return creation_date;
	}

	/**
	 * Défini la date de création
	 * de la conversatino
	 * @param date_creation la date de création de la 
	 * conversation
	 */
	public void setCreationDate(String date_creation) 
	{
		this.creation_date = date_creation;
	}

	/**
	 * Renoi la liste des posts (messages)
	 * de la conversation
	 * @return liste des posts
	 */
	public ArrayList<Post> getPosts() 
	{
		return posts;
	}

	/**
	 * Défini la liste des posts
	 * (messages) de la conversation
	 * @param posts liste des posts
	 */
	public void setPosts(ArrayList<Post> posts) 
	{
		this.posts = posts;
	}
	
	/**
	 * Renvoi le nombre des
	 * posts (messages) de la 
	 * conversation
	 * @return nombre des posts
	 */
	public int getNbPosts()
	{
		return posts.size();
	}
	
	/**
	 * Ajout un post (message)
	 * dans la conversation
	 * @param p Post à ajouter
	 */
	public void addPost(Post p)
	{
		posts.add(p);
	}
}
