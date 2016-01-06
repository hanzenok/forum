package m2geii.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m2geii.forum.beans.Conversation;

public class PostsServlet extends HttpServlet 
{	
	private static final long serialVersionUID = -8335553417683716525L;
	
	public static final String VIEW_CONVERSATIONS = "/WEB-INF/conversations.jsp";
	public static final String VIEW_POSTS = "/WEB-INF/conversation.jsp";
	
	public static final String ATT_CONVS = "conversations";
	public static final String ATT_CONV = "conversation";
	public static final String ATT_CONV_INDEX = "conversation_index";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		//l'indice de conversation cliquee
		int conversation_index = Integer.parseInt(request.getParameter(ATT_CONV_INDEX));
		
		//reccuperation des conversations
		HttpSession session = request.getSession();
		ArrayList<Conversation> conversations = (ArrayList<Conversation>) session.getAttribute(ATT_CONVS);
		
		//passer une conversation a la vue
		Conversation conversation = conversations.get(conversation_index);
		request.setAttribute(ATT_CONV, conversation);
		
		this.getServletContext().getRequestDispatcher(VIEW_POSTS).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		
	}
}

