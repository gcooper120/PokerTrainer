import java.util.*;
/**
	* Deck is a class used to represent ta deck of cards
	* @author Machi
	*/
public class Deck
	{
	//Array holding ordered deck, will be hard coded.
	private Card fullDeck[];

	//Flag set to 0 when deck is unshuffled, set to 1 after shuffle.
	private boolean ready;

	//Stack for the current deck. Using a stack because pop will make dealing easy.
	private Stack<Card> currentDeck;

	//Deck constructor. just needs to initialize the stack and set flag.
	/**
	*Constructor. Creates a deck object.
	*@return Nothing.
	*/
	public Deck()
	{
		fullDeck = new Card[52];
		currentDeck = new Stack<Card>();
		//Populates the ordered deck, assigning one suit at a time.
		//i%13+1=value between 1-13,
		//i/13+1 = value between 1-4.
		for (int i = 51; i >= 0; i--)
		{
			fullDeck[i] = new Card(i%13+1, i/13+1);
			currentDeck.push(fullDeck[i]);
		}

		ready = false;
	}


	/**
	*Shuffles a deck object and returns a stack representing the deck.
	*@return Nothing.
	*/
	public void shuffle()
	{
		int randomVal;
		int numLeft = fullDeck.length;
		currentDeck.clear();
		for (int i = 0; i < 52; i++, numLeft--)
		{
			randomVal = (int)Math.floor(Math.random() * (52-i));
			currentDeck.push(fullDeck[randomVal]);
			swapCards(randomVal, numLeft-1);
		}
		ready = true;
	}

	/**
	*Swaps two cards in the deck.
	*@param int Index of the first card
	*@parma int Index of the second card
	*@return Nothing.
	*/
	public void swapCards(int first, int second)
	{
		Card temp = fullDeck[second];
		fullDeck[second] = fullDeck[first];
		fullDeck[first] = temp;
	}

	/**
	*Prints the contents of a deck
	*@return Nothing.
	*/
	public void printDeck()
	{
		for (int i = 0; i < 52; i++)
		{
			Card current = currentDeck.pop();
			current.printCard();
		}
	}

	/**
	*Checks if deck is ready for new round
	*@return ready Boolean indicating whether deck is ready for a new round
	*/
	public boolean isReady()
	{
		return ready;
	}

	/**
	*Updates the ready variable to false so that a new hand can't be dealt
	*@return Nothing.
	*/
	public void unReady()
	{
		ready = false;
	}

	/**
	*Returns the top card from the deck
	*@return Card Top of the stack representing the deck
	*/
	public Card getTopCard()
	{
		return currentDeck.pop();
	}
}