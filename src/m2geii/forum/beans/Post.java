package m2geii.forum.beans;

public class Post {

	private int id;
	private int number;
	
	private User author;
	private String date;
	private String text;
	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
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
	
	public String getDate() 
	{
		return date;
	}
	
	public void setDate(String date) 
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
