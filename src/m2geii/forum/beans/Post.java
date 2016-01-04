package m2geii.forum.beans;

import org.joda.time.DateTime;

public class Post {

	private Long id;
	private int number;
	
	private User author;
	private DateTime date;
	private String text;
	
	
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public int getNumber() 
	{
		return number;
	}

	public void setNumber(int number) 
	{
		this.number = number;
	}

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
