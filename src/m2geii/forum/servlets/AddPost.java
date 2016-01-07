package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.Conversation;
import m2geii.forum.beans.Post;
import m2geii.forum.beans.User;

public class AddPost extends HttpServlet {

	private static final long serialVersionUID = -535869300843163393L;

	public static final String VIEW_POSTS = "/WEB-INF/conversation.jsp";
	
	public static final String FIELD_POST = "addpost";
	
	public static final String ATT_USER = "user";
	public static final String ATT_CONV = "conversation";
	public static final String ATT_CONV_INDEX = "conversation_index";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		System.out.println("yes");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		//reccuperation des parametres
		String post_text = request.getParameter(FIELD_POST);
		
		if(!post_text.equals(""))
		{
			//reccuperation de user actuel
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(ATT_USER);
			
			//reccuperation de conversation courante
			Conversation conversation = (Conversation) request.getAttribute(ATT_CONV);
			int conversation_index = Integer.parseInt(request.getParameter(ATT_CONV_INDEX));
			
			//creation de bean post
			Post post = new Post();
			post.setAuthor(user);
			//post.setNumber(conversation.getNbPosts() + 1);
			post.setText(post_text);
			
			System.out.println(conversation + " " + post.getAuthor() + " " + post.getNumber() + " " + post.getText());
		}
		
		//redirection
		this.getServletContext().getRequestDispatcher(VIEW_POSTS).forward(request, response);
	}

}
