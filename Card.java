import java.util.*;

/**
	* Card is a class used to represent a card in standard Texas-Holdem.
	* @author Machi
	*/
public class Card
{
	private int number;
	private int suit;

	/**
	* Constructor for a card object.
	*@param n First parameter is an integer between 1-13 with 1=Ace and 11-13=Face cards
	*@parma s Second parameter is the card suit, 1=Club, 2=Diamond, 3=Heart, 4=Spade
	*@return Nothing.
	*/
	public Card(int n, int s)
	{
		if (s < 1 || s > 4 || n < 1 || n > 13)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			number = n;
			suit = s;
		}
	}

	/**
	*Gets the number value
	*@return number The number associated with the card (1-13)
	*/
	public int getNumber()
	{
		return number;
	}

	/**
	*Gets the suit value
	*@return suit The suit associated with the card (1-4)
	*/
	public int getSuit()
	{
		return suit;
	}

	public void printCard()
	{
		char suitChar;
		switch (suit)
		{
			case 1:
			{
				suitChar = 'C';
				break;
			}

			case 2:
			{
				suitChar = 'D';
				break;
			}
			
			case 3:
			{
				suitChar = 'H';
				break;
			}
			
			case 4:
			{
				suitChar = 'S';
				break;
			}	
			default:
			{
				suitChar = '?';
				break;
			}
		}

		if (number == 1)
		{
			System.out.printf("%2c%c\n", 'A', suitChar);
		}
		else
		{
			System.out.printf("%2d%c\n", number, suitChar);
		}
	}
}