import java.util.*;
import java.lang.*;

/**
	* OutEngine is a class used for calculating a player's outs given hand and community cards
	* @author Machi
	*/
public class OutEngine
{
	
	boolean hasStraight;
	boolean hasFlush;
	boolean hasPair;
	boolean has2Pair;
	boolean hasTrips;
	/**
	*Calculates a players outs
	*@param p Player whom we are calculating outs for.
	*@param communityCards Current table's community cards.
	*/

	public void OutEngine()
	{
		hasStraight = false;
		hasFlush = false;
		hasPair = false;
		has2Pair = false;
		hasTrips = false;
	}

	public void reset()
	{
		hasStraight = false;
		hasFlush = false;
		hasPair = false;
		has2Pair = false;
		hasTrips = false;
	}
	public  void calcOuts(Player p, Card[] communityCards)
	{
		Card allCards[] = new Card[2+communityCards.length];
		Card hand[] = p.getHand();
		allCards[0] = hand[0];
		allCards[1] = hand[1];
		for (int i = 0; i < communityCards.length; i++)
		{
			allCards[i+2] = communityCards[i];
		}

		ArrayList<Integer> cVals = new ArrayList<Integer>();
		ArrayList<Integer> sVals  = new ArrayList<Integer>();
		for (int i = 0; i < allCards.length; i++)
		{
			cVals.add(allCards[i].getNumber());
			sVals.add(allCards[i].getSuit());
		}
	}

	public  boolean straightFlush(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		//This actually does royal flush rn. trying to fix.
		boolean ret = false;
		if (!hasStraight || !hasFlush)
		{
			ret = false;
		}
		else
		{
			ArrayList<Integer> royals = new ArrayList<Integer>();
			royals.addAll(Arrays.asList(10,11,12,13,1));
			if (cardVals.containsAll(royals))
			{
				if (suitVals.get(cardVals.indexOf(10)).equals(suitVals.get(cardVals.indexOf(11)))
					&&suitVals.get(cardVals.indexOf(11)).equals(suitVals.get(cardVals.indexOf(12))))
				{
					ret = true;
				}
				else
				{
					ret =false;
				}
			}
		}
		return ret;
	}
	public boolean quads(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		boolean ret = false;
		if (!hasTrips)
		{
			ret = false;
		}
		else
		{
			int size = cardVals.size();
			int secondIndex;
			int thirdIndex;
			for (int i = 0; i < size-3; i++)
			{
				if (cardVals.subList(i+1, size).contains(cardVals.get(i)))
				{
					secondIndex = cardVals.subList(i+1, size).indexOf(cardVals.get(i));
					if (cardVals.subList(secondIndex+1, size).contains(cardVals.get(i)))
					{
						thirdIndex = cardVals.subList(secondIndex+1, size).indexOf(cardVals.get(i));
						if (cardVals.subList(thirdIndex+1, size).contains(cardVals.get(i)))
						{
							ret = true;
							break;
						}
					}
				}
			}
		}
		return ret;
	}

	public  boolean fullHouse(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		boolean ret;
		if (!has2Pair || !hasTrips)
		{
			ret = false;
		}
		else
		{
			ret = true;
		}
		return ret;
	}
	public boolean flush(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		int maxOneSuit = 0;
		int temp = 0;
		boolean ret = false;
		for (int i = 1; i <= 4; i++)
		{
			temp = Collections.frequency(suitVals, i);
			if (temp > maxOneSuit)
			{
				maxOneSuit = temp;
			}
		}
		if (maxOneSuit >= 5)
		{
			ret = true;
		}
		else
		{
			ret = false;
		}
		return ret;
	}
	public boolean straight(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		boolean ret = false;
		ArrayList<Integer> possibleValues = new ArrayList<Integer>();
		possibleValues.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,1));
		for (int i = 0; i < possibleValues.size()-4; i++)
		{
			if (cardVals.containsAll(possibleValues.subList(i, i+4)))
			{
				ret = true;
				hasStraight = true;
				break;
			}
		}
		return ret;
	}
	public boolean trips(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		boolean ret = false;
		int size = cardVals.size();
		int secondIndex;
		for (int i = 0; i < size-2; i++)
		{
			if (cardVals.subList(i+1, size).contains(cardVals.get(i)))
			{
				secondIndex = cardVals.subList(i+1, size).indexOf(cardVals.get(i));
				if (cardVals.subList(i+2, size).contains(cardVals.get(i)))
				{
					ret = true;
					break;
				}
			}
		}
		return ret;
	}
	public boolean pair2(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		boolean ret = false;
		int count = 0;
		int size = cardVals.size();
		for (int i = 0; i < size-1; i++)
		{
			if (cardVals.subList(i+1, size).contains(cardVals.get(i)))
			{
				count++;
			}
		}
		if (count == 2)
		{
			ret = true;
			has2Pair = true;
		}
		else
		{
			ret = false;
		}
		return ret;
	}
	public boolean pair(ArrayList<Integer> cardVals, ArrayList<Integer> suitVals)
	{
		boolean ret = false;
		int size = cardVals.size();
		for (int i = 0; i < size-1; i++)
		{
			if (cardVals.subList(i+1, size).contains(cardVals.get(i)))
			{
				ret = true;
				hasPair = true;
				break;
			}
		}
		return ret;
	}

	public static void main(String[] args)
	{
		OutEngine myOE = new OutEngine();
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		myArray.add(5);
		myArray.add(5);
		myArray.add(2);
		myArray.add(5);
		myArray.add(5);
		ArrayList<Integer> myArray2 = new ArrayList<Integer>();
		myArray2.add(1);
		myArray2.add(1);
		myArray2.add(1);
		myArray2.add(1);
		myArray2.add(1);
		ArrayList<Integer> myArray3 = new ArrayList<Integer>();
		myArray3.add(1);
		myArray3.add(10);
		myArray3.add(11);
		myArray3.add(12);
		myArray3.add(13);
		System.out.println(myOE.straightFlush(myArray, myArray2));
		myOE.reset();
		System.out.println(myOE.straightFlush(myArray3, myArray2));
	}
}