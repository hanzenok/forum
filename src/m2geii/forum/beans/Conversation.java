package m2geii.forum.beans;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Conversation {
	
	private User author;
	
	private String title;
	
	private DateTime date_creation;
	private DateTime date_modification;
	
	private ArrayList<Post> posts;

	
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

	public DateTime getCreationDate() 
	{
		return date_creation;
	}

	public void setCreationDate(DateTime date_creation) 
	{
		this.date_creation = date_creation;
	}

	public DateTime getModifDate() 
	{
		return date_modification;
	}

	public void setModifDate(DateTime date_modification) 
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
