import java.util.*;

/**
	* Player is a class used to represent a in standard Texas-Holdem
	* @author Machi
	*/
public class Player
{
	private Card hand[];


	/**
	*Constructor. Initializes makeFlags array and creates hand
	*@return Nothing.
	*/
	public Player()
	{
		hand = new Card[2];
		hand[0] = null;
		hand[1] = null;
	}

	/**
	* Sets the hand cards. Will be called by the dealer.
	*@param first First Card given to player
	*@param second Second Card given to player
	*@return Nothing.
	*/
	public void setHand(Card first, Card second)
	{
		hand[0] = first;
		hand[1] = second;
	}

	/**
	* Gives one card to the player.
	*@param c Card to be given to the player
	*@param cNum Card number to be given to the player. (First or second, 1-2)
	*@return Nothing.
	*/
	public void giveCard(Card c, int cNum)
	{
		try
		{
			hand[cNum] = c;
		}
		catch (ArrayIndexOutOfBoundsException x)
		{
			System.err.println("Illegal card assignment");
			x.printStackTrace();
		}
	}

	/**
	* Clear's a player's hand
	*@return Nothing.
	*/
	public void clearHand()
	{
		hand[0] = null;
		hand[1] = null;
	}

	/**
	* Returns the hand, needed to determine winner and calculate odds
	* @return hand Returns the array representing the hand.
	*/
	 public Card[] getHand()
	 {
	 	return hand;
	 }

	 /**
	 *Prints out the player's hand
	 *@return Nothing.
	 */
	 public void printHand()
	 {
	 	hand[0].printCard();
	 	hand[1].printCard();
	 }

}