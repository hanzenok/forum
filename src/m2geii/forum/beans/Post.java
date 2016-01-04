package m2geii.forum.beans;

import org.joda.time.DateTime;

public class Post {

	private User author;
	private DateTime date;
	private String text;
	
	
	public User getAuthor() 
	{
		return author;
	}
	
	public void setAuthor(User author) 
	{
		this.author = author;
	}
	
	public DateTime getDate() 
	{
		return date;
	}
	
	public void setDate(DateTime date) 
	{
		this.date = date;
	}
	
	public String getText() 
	{
		return text;
	}
	
	public void setText(String text) 
	{
		this.text = text;
	}
	
}
