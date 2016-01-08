package m2geii.forum.beans;

/**
 * Un bean qui répresente
 * un utilisatuer
 * 
 * @author Ganza Mykhailo
 */
public class User 
{	
	private int id; //id de user dans la bd
	
	private String login; //login d'utilisateur
	private String pass;  //mote de passe 
	
	private String firstname; //prenom
	private String secondname; //nom
	
	/**
	 * Renvoit l'id de bd
	 * d'utilisateur
	 * @return id
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * Défini l'id de bd 
	 * de l'utilisateur
	 * @param id id
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Renvoi logint de
	 * l'utilisateur
	 * @return login
	 */
	public String getLogin() 
	{
		return login;
	}
	
	/**
	 * Défini le login d'utilisateur
	 * @param login login
	 */
	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	/**
	 * Renvoi le mot de passe 
	 * de l'utilisateur
	 * @return mot de pass
	 */
	public String getPass() 
	{
		return pass;
	}
	
	/**
	 * Défini le mot de passe 
	 * d'utilisateur
	 * @param pass mot de passe
	 */
	public void setPass(String pass) 
	{
		this.pass = pass;
	}
	
	/**
	 * Revnoi le prenom d'utilisateur
	 * @return prenom d'utilisateur
	 */
	public String getFirstname() 
	{
		return firstname;
	}
	
	/**
	 * Défini le prenom d'utilisateur
	 * @param firstname
	 */
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	/**
	 * Renvoi le nom d'utilisateur
	 * @return nom d'utilisateur
	 */
	public String getSecondname() 
	{
		return secondname;
	}
	
	/**
	 * Défini le nom d'utilisatuer
	 * @param secondname nom d'utilisatuer
	 */
	public void setSecondname(String secondname) 
	{
		this.secondname = secondname;
	}

	
}
