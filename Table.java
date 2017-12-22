import java.util.*;

/**
	*Table is a class used to represent the table in standard Texas-Holdem
	*@author Machi
	*/
public class Table
{
	private Card communityCards[];

	private Player players[];

	private int communityCardCount = 0;

	private int numPlayers = 0;

/**
	*Constructor. Assigns a deck to this dealer.
	*@param numPlayers Number of players sitting at the table.
	*@return Nothing.
	*/
	public Table(int np)
	{
		communityCards = new Card[5];
		players = new Player[np];
		for (int i = 0;  i < np; i++)
		{
			players[i] = new Player();
		}
		numPlayers = np;

	}

/**
	*Adds cards to community cards, will be called by dealer.
	*@return Nothing.
	*/
	public void addCommunityCard(Card c)
	{
		communityCards[communityCardCount] = c;
		communityCardCount++;
		return;
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
	public void addPlayer(Player p)
	{

	}

/**
	*Removes a player to the game. Must be called when no community cards exist.
	*@return Nothing.
	*/
	public void removePlayer(Player p)
	{

	}
/**
	*Returns the number of players at the table.
	*@return numPlayers Integer representing number of players.
	*/
	public int getNumPlayers()
	{
		return numPlayers;
	}

	/**
	*Returns the player specified by a specific index
	*@param index Index of player.
	*@return Player Specified player.
	*/
	public Player getPlayer(int index)
	{
		return players[index];
	}

	/**
	*Clears all players' hands
	*@return Nothing.
	*/
	private void clearHands()
	{
		for (int i = 0; i < numPlayers; i++)
		{
			players[i].clearHand();
		}
		return;
	}

	/**
	*Clears the entire table in preperation for the next round
	*@return Nothing.
	*/
	public void clearTable()
	{
		clearCommunityCards();
		clearHands();
		return;
	}
	/**
	*Prints the state of the game, player's and their hands first, community cards second
	*@return Nothing.
	*/
	public void printState()
	{
		for (int i = 0; i < numPlayers; i++)
		{
			System.out.println("Player " + i);
			players[i].printHand();
			System.out.println();
		}
		System.out.print("\n\n");
		for (int i = 0; i < communityCardCount; i++)
		{
			communityCards[i].printCard();
		}
		for (int i = communityCardCount; i < 5; i++)
		{
			System.out.println("___");
		}
	}
}