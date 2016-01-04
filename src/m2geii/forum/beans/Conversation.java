package m2geii.forum.beans;

import java.util.ArrayList;

public class Conversation {
	
	private int id;
	private User author;
	private String title;
	
	private String creation_date;
	private String modification_date;
	
	private ArrayList<Post> posts;

	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
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
		return creation_date;
	}

	public void setCreationDate(String date_creation) 
	{
		this.creation_date = date_creation;
	}

	public String getModificationDate() 
	{
		return modification_date;
	}

	public void setModifDate(String modification_date) 
	{
		this.modification_date = modification_date;
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
