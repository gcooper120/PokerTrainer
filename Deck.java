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
		currentDeck = new Stack<Card>();
		ready = 0;
	}


	/**
	*Shuffles a deck object and returns a stack representing the deck.
	*@return Stack<Card> Returns the shuffled deck as a stack.
	*/
	private Stack<Card> shuffle()
	{

		ready = 1;
		return currentDeck;
	}

}