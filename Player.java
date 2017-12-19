import java.util.*;

/**
	* Player is a class used to represent a in standard Texas-Holdem
	* @author Machi
	*/
public class Player
{
	private Card hand[];

	private byte makeFlags[];
	/*
	0 -> High Card
	1 -> Pair
	2 -> Two Pair
	3 -> Three of a Kind
	4 -> Straight
	5 -> Flush
	6 -> Full House
	7 -> Quads
	8 -> Straight Flush
	*/

	/**
	*Constructor. Initializes makeFlags array and creates hand
	*@return Nothing.
	*/
	public Player()
	{
		hand = new Card[2];
		makeFlags = new byte[] {1,1,1,1,1,1,1,1,1};
	}

	/**
	* Sets the hand cards. Will be called by the dealer.
	*@return Nothing.
	*/
	public void setHand(Card first, Card second)
	{
		hand[0] = first;
		hand[1] = second;
	}

	/**
	* Returns the hand, needed to determine winner and calculate odds
	* @return hand Returns the array representing the hand.
	*/
	 public Card[] getHand()
	 {
	 	return hand;
	 }

}