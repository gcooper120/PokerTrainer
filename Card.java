import java.util.*;

/**
	* Card is a class used to represent a card in standard Texas-Holdem.
	* @author Machi
	*/
public class Card
{
	int number;
	int suit;

	/**
	* Constructor for a card object.
	*@param n First parameter is an integer between 1-13 with 1=Ace and 11-13=Face cards
	*@parma s Second parameter is the card suit, 1=Club, 2=Diamond, 3=Heart, 4=Spade
	*@return Nothing.
	*/
	public Card(int n, int s)
	{
		number = n;
		suit = s;
	}
}