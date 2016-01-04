package m2geii.forum.beans;

import java.util.ArrayList;

public class Conversation {
	
	private Long id;
	private User author;
	private String title;
	
	private String date_creation;
	private String date_modification;
	
	private ArrayList<Post> posts;

	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public User getAuthor() 
	{
		return author;
	}

	public void setAuthor(User author) 
	{
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getCreationDate() 
	{
		return date_creation;
	}

	public void setCreationDate(String date_creation) 
	{
		this.date_creation = date_creation;
	}

	public String getModifDate() 
	{
		return date_modification;
	}

	public void setModifDate(String date_modification) 
	{
		this.date_modification = date_modification;
	}

	public ArrayList<Post> getPosts() 
	{
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) 
	{
		this.posts = posts;
	}
}
