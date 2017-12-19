import java.util.*;

/**
	*Table is a class used to represent the table in standard Texas-Holdem
	*@author Machi
	*/
public class Table
{
	private Card communityCards[];

	int communityCardCount = 0;

	private Player players[];

/**
	*Constructor. Assigns a deck to this dealer.
	*@param numPlayers Number of players sitting at the table.
	*@return Nothing.
	*/
	public Table(int numPlayers)
	{
		communityCards = new Card[5];
		players = new Player[numPlayers];
	}

/**
	*Adds cards to community cards, will be called by dealer.
	*@return Nothing.
	*/
	private void addCommunityCard()
	{

	}

/**
	*Removes all community cards, will be called by dealer.
	*@return Nothing.
	*/
	private void clearCommunityCards()
	{
		communityCards = new Card[5];
		communityCardCount = 0;
	}

/**
	*Adds a player to the game. Must be called when no community cards exist.
	*@return Nothing.
	*/
	private void addPlayer(Player p)
	{

	}

/**
	*Removes a player to the game. Must be called when no community cards exist.
	*@return Nothing.
	*/
	private void removePlayer(Player p)
	{

	}

}