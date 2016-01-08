package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.Conversation;
import m2geii.forum.beans.Conversations;
import m2geii.forum.beans.ForumDB;
import m2geii.forum.beans.Post;
import m2geii.forum.beans.User;

/**
 * Une servlet d'ajout
 * d'un nouveau post dans la bd
 * et un bean Conversations de 
 * la session
 * 
 * @author Ganza Mykhailo
 */
public class AddPost extends HttpServlet {

	private static final long serialVersionUID = -535869300843163393L;

	public static final String SERVLET_POSTS = "/forum/main/posts";
	public static final String SERVLET_INDEX = "/forum/index";
	
	public static final String FIELD_POST = "addpost";
	
	public static final String ATT_USER = "user";
	public static final String ATT_CONVS = "conversations";

	/**
	 * Repod à un clicque sur un bouton "ajouter" (post)
	 * Ajout un nouveau post 
	 * dans la bd et un bean
	 * Conversations de la session
	 * Repasse comme parametre lindice 
	 * de la conversation choisi
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//session
		HttpSession session = request.getSession();
		
		//verification de user
		User user = (User)session.getAttribute(ATT_USER);
		if(user == null)
		{
			response.sendRedirect(SERVLET_INDEX);
			return;
		}
		
		//reccuperation des parametres
		String post_text = request.getParameter(FIELD_POST);
		
		//reccuperation de bean conversations
		Conversations conversations = (Conversations)session.getAttribute(ATT_CONVS);
		
		if(!post_text.equals(""))
		{
			//reccuperation de user actuel
			user = (User)session.getAttribute(ATT_USER);
			
			//reccuperation de conversation courante
			Conversation conversation = conversations.getCurrentConversation();
			
			//creation de bean post
			Post post = new Post();
			post.setAuthor(user);
			post.setNumber(conversation.getNbPosts() + 1);
			post.setText(post_text);
			
			//ajout dans la db
			ForumDB db = new ForumDB();
			int id = db.addPost(user.getLogin(), conversation.getNbPosts() + 1, post_text, conversation.getId());
			
			//et dans les conversations
			Post new_post = db.getPost(id);
			new_post.setAuthor(post.getAuthor());
			conversation.addPost(new_post);
		}
		
		//redirection
		response.sendRedirect(SERVLET_POSTS + "?conversation_index=" + conversations.getCurrentConversationIndex());
	}

}
