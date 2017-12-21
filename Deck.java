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
	private byte ready;

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

		ready = 0;
	}


	/**
	*Shuffles a deck object and returns a stack representing the deck.
	*@return Nothing.
	*/
	private void shuffle()
	{
		int randomVal;
		int numLeft = fullDeck.length;
		for (int i = 0; i < 52; i++, numLeft--)
		{
			randomVal = (int)Math.floor(Math.random() * (52-i));
			currentDeck.push(fullDeck[randomVal]);
			swapCards(randomVal, numLeft-1);
		}
		ready = 1;
	}

	/**
	*Swaps two cards in the deck.
	*@param int Index of the first card
	*@parma int Index of the second card
	*@return Nothing.
	*/
	private void swapCards(int first, int second)
	{
		Card temp = fullDeck[second];
		fullDeck[second] = fullDeck[first];
		fullDeck[first] = temp;
	}

	/**
	*Prints the contents of a deck
	*@return Nothing.
	*/
	private void printDeck()
	{
		for (int i = 0; i < 52; i++)
		{
			Card current = currentDeck.pop();
			current.printCard();
		}
	}
}