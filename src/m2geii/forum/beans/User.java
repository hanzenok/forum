package m2geii.forum.beans;

public class User 
{	
	private Long id;
	
	private String login;
	private String pass;
	
	private String firstname;
	private String secondname;
	
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public String getLogin() 
	{
		return login;
	}
	
	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getPass() 
	{
		return pass;
	}
	
	public void setPass(String pass) 
	{
		this.pass = pass;
	}
	
	public String getFirstname() 
	{
		return firstname;
	}
	
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	public String getSecondname() 
	{
		return secondname;
	}
	
	public void setSecondname(String secondname) 
	{
		this.secondname = secondname;
	}

	
}
