import java.util.*;

/**
	* PokerDealer is a class used to represent the dealer in standard Texas-Holdem
	* @author Machi
	*/
public class PokerDealer
{
	Deck gameDeck;
	Table gameTable;
	boolean hasFlop;
	boolean hasTurn;
	boolean hasRiver;
	/**
	*Constructor. Assigns a deck to this dealer.
	*@param gd Deck object used for the game.
	*@return Nothing.
	*/
	public PokerDealer(int numPlayers)
	{
		if (numPlayers < 1 || numPlayers > 9)
		{
			System.out.println("Too many players. Defaulting to 9");
			gameTable = new Table(9);
		}
		else
		{
			gameTable = new Table(numPlayers);
		}
		gameDeck = new Deck();
		hasRiver = false;
		hasTurn = false;
		hasFlop = false;
	}

	/**
	* Deal is a method used to give hands out to players.
	* @param players Integer between 1 and 9 indicating number of players.
	* @return Nothing.
	*/
	public void deal()
	{
		if (!gameDeck.isReady())
		{
			gameDeck.shuffle();
		}
		gameTable.clearTable();
		hasFlop = false;
		hasTurn = false;
		hasRiver = false;
		int n = gameTable.getNumPlayers();
		Player p;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < n; j++)
			{
				p = gameTable.getPlayer(j);
				p.giveCard(gameDeck.getTopCard(), i);
			}
		}
		gameDeck.unReady();
	} 

	/**
	* Flop is a method used to lay the first 3 communal cards (flop) down.
	* @return Nothing.
	*/
	public void flop()
	{
		if (hasFlop)
		{
			System.err.println("Flop already placed");
		}
		else
		{
			gameTable.addCommunityCard(gameDeck.getTopCard());
			gameTable.addCommunityCard(gameDeck.getTopCard());
			gameTable.addCommunityCard(gameDeck.getTopCard());
			hasFlop = true;
		}
	}

	/**
	* Turn is a method used to lay the fourth communal card (turn) down.
	* @return Nothing.
	*/
	public void turn()
	{
		if (hasFlop && !hasTurn)
		{
			gameTable.addCommunityCard(gameDeck.getTopCard());
			hasTurn = true;
		}
		else if (!hasFlop)
		{
			System.err.println("Flop needs to happen before turn.");
		}
		else
		{
			System.err.println("Turn already placed.");
		}
	}

	/**
	* River is a method used to lay the fifth communal card (river) down.
	* @return Nothing.
	*/
	public void river()
	{
		if (hasFlop && hasTurn && !hasRiver)
		{
			gameTable.addCommunityCard(gameDeck.getTopCard());
			hasRiver = true;
		}
		else if(!hasFlop || !hasTurn)
		{
			System.err.println("Need flop and turn before river.");
		}
		else
		{
			System.err.println("River already placed");
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Welcome to PokerDealer");
		System.out.println("Initializing Dealer...");
		PokerDealer myDealer = new PokerDealer(3);
		myDealer.deal();
		myDealer.flop();
		myDealer.turn();
		myDealer.river();
		myDealer.gameTable.printState();
		myDealer.deal();
		myDealer.flop();
		myDealer.turn();
		myDealer.river();
		myDealer.gameTable.printState();
		myDealer.deal();
		myDealer.flop();
		myDealer.turn();
		myDealer.river();
		myDealer.gameTable.printState();
		myDealer.deal();
		myDealer.flop();
		myDealer.turn();
		myDealer.river();
		myDealer.gameTable.printState();
	}
}