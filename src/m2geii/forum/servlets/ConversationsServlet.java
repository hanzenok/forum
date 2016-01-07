package m2geii.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.Conversations;
import m2geii.forum.beans.ForumDB;
import m2geii.forum.beans.User;

public class ConversationsServlet extends HttpServlet 
{	
	private static final long serialVersionUID = -4312652067101625925L;
	
	public static final String VIEW_CONVERSATIONS = "/WEB-INF/conversations.jsp";
	public static final String SERVLET_INDEX = "/forum/index";
	
	public static final String ATT_USER = "user";
	public static final String ATT_CONVS = "conversations";
	public static final String ATT_CONV = "conversation";
	public static final String ATT_CONV_INDEX = "conversation_index";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
		
		//reccuperer les conversations de la db
		ForumDB db = new ForumDB();
		Conversations conversations = db.getConversations();
		
		//ajout dans la session
		session.setAttribute(ATT_CONVS, conversations);
		
		//redirection
		this.getServletContext().getRequestDispatcher(VIEW_CONVERSATIONS).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		this.getServletContext().getRequestDispatcher(VIEW_CONVERSATIONS).forward(request, response);
	}
}
