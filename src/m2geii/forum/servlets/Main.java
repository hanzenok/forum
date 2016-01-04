package m2geii.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m2geii.forum.beans.Conversation;
import m2geii.forum.beans.ForumDB;

public class Main extends HttpServlet 
{	
	private static final long serialVersionUID = -4312652067101625925L;
	
	public static final String VIEW_MAIN = "/WEB-INF/main.jsp";
	public static final String ATT_CONV = "conversations";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		//reccuperer les conversations de la db
		ForumDB db = new ForumDB();
		ArrayList<Conversation> conversations = db.getConversations();
		
		//le passer a la vue
		request.setAttribute(ATT_CONV, conversations);
		
		this.getServletContext().getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{	
		this.getServletContext().getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}
}
