package m2geii.forum.beans;

import java.util.ArrayList;


/**
 * Un bean qui répresente
 * une ensemble des conversations
 * 
 * @author Ganza Mykhailo
 */
public class Conversations {
	
	private ArrayList<Conversation> conversations_list; //liste de conversations
	private int current_conversation_index; //l'index de la conversation courante
	//choisi par l'utilisateur
	
	/**
	 * Constructeur principal
	 */
	public Conversations()
	{
		current_conversation_index = -1;
	}

	/**
	 * Renvoi la liste des 
	 * conversations
	 * @return liste des conversations
	 */
	public ArrayList<Conversation> getConversationsList() 
	{
		return conversations_list;
	}

	/**
	 * Défini la liste des conersations
	 * @param conversations_list liste
	 * des conversations
	 */
	public void setConversationsList(ArrayList<Conversation> conversations_list) 
	{
		this.conversations_list = conversations_list;
	}
	
	/**
	 * Renvoi l'indice de la conversation
	 * actuellement choisi par l'utilisateur
	 * @return l'indice de la conversation courante
	 */
	public int getCurrentConversationIndex() 
	{
		return current_conversation_index;
	}
	
	/**
	 * Défini l'indice de la conversation courante
	 * @param current_conversation_index l'indice de la conversation courante
	 */
	public void setCurrentConversation(int current_conversation_index) 
	{
		this.current_conversation_index = current_conversation_index;
	}
	
	/**
	 * Renvoi une conversation actuellemnt
	 * choisi par l'utilisateur
	 * @return conversation courante
	 */
	public Conversation getCurrentConversation()
	{
		return conversations_list.get(current_conversation_index);
	}
	
	/**
	 * Renvoi le nombre des conversations total
	 * @return nombre des conversations
	 */
	public int getNbConversations()
	{
		return conversations_list.size();
	}
	
	/**
	 * Renvoi le nombre des posts (messages)
	 * des toutes les conversations
	 * @return nombre des messages totales
	 */
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
