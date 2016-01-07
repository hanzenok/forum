package m2geii.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.Conversation;
import m2geii.forum.beans.Conversations;
import m2geii.forum.beans.ForumDB;

public class Main extends HttpServlet 
{	
	private static final long serialVersionUID = -4312652067101625925L;
	
	public static final String VIEW_CONVERSATIONS = "/WEB-INF/conversations.jsp";
	
	public static final String ATT_CONVS = "conversations";
	public static final String ATT_CONV = "conversation";
	public static final String ATT_CONV_INDEX = "conversation_index";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		//reccuperer les conversations de la db
		ForumDB db = new ForumDB();
		Conversations conversations = db.getConversations();
		
		//session
		HttpSession session = request.getSession();
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
