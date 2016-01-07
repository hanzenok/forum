package m2geii.forum.beans;

import java.util.ArrayList;

public class Conversations {
	
	private ArrayList<Conversation> conversations_list;
	private int current_conversation_index;
	
	public Conversations()
	{
		current_conversation_index = -1;
	}

	public ArrayList<Conversation> getConversationsList() 
	{
		return conversations_list;
	}

	public void setConversationsList(ArrayList<Conversation> conversations_list) 
	{
		this.conversations_list = conversations_list;
	}

	public int getCurrentConversationIndex() 
	{
		return current_conversation_index;
	}

	public void setCurrentConversation(int current_conversation_index) 
	{
		this.current_conversation_index = current_conversation_index;
	}
	
	public Conversation getCurrentConversation()
	{
		return conversations_list.get(current_conversation_index);
	}
	
	public int getNbConversations()
	{
		return conversations_list.size();
	}
	
	public int getNbPosts()
	{
		int n = 0;
		
		for(Conversation conversation : conversations_list)
		{
			n += conversation.getNbPosts();
		}
		
		return n;
	}
	
}
