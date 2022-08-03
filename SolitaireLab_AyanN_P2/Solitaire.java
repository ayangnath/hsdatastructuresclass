import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;

/**
 * The Solitaire game allows us to 
 * play the Solitaire game!
 * Users can move cards and place them
 * piles to attempt to win the game
 * 
 * @author Ayan Nath
 * 
 * @version 12/4/2021
 */
public class Solitaire
{
	/**
	 * Main method for the Solitaire Class.
	 * @param args arguments from the command line
	 */
	public static void main(String[] args)
	{
		new Solitaire();
	}

	private Stack<Card> stock;
	private Stack<Card> waste;
	private Stack<Card>[] foundations;
	private Stack<Card>[] piles;
	private SolitaireDisplay display;

	/**
	 * Constructor for the Solitaire class
	 */
	public Solitaire()
	{
		foundations = new Stack[4];
		piles = new Stack[7];

		for (int i = 0; i < 4; i++)
		{
			foundations[i] = new Stack<Card>();
		}

		for (int i = 0; i < 7; i++)
		{
			piles[i] = new Stack<Card>();
		}
		stock = new Stack<Card>();
		createStock();
		waste = new Stack<Card>();

		deal();

		display = new SolitaireDisplay(this);
	}

	
	/**
	 * gives back the card at the top of the stock,
	 * or null if the stock is empty
	 * @return the card on the top of the stock.
	 */
	public Card getStockCard()
	{
		if (stock.isEmpty())
			return null;

		else return stock.peek();
	}

	
	/**
	 * returns the card on the top of the waste,
	 * or null if the waste is empty
	 * @return null if the waste is empty
	 */
	public Card getWasteCard()
	{
		if (waste.isEmpty())
			return null;

		else return waste.peek();
	}

	//precondition:  0 <= index < 4
	//postcondition: returns the card on top of the given
	//               foundation, or null if the foundation
	//               is empty
	/**
	 * Gives the card on the top of the given foundation,
	 * or null if the foundation is empty
	 * @param index the index of the foundation
	 * @return the card at the foundation of the given index
	 */
	public Card getFoundationCard(int index)
	{
		if (foundations[index].isEmpty())
			return null;

		else return foundations[index].peek();
	}

	//precondition:  0 <= index < 7
	//postcondition: returns a reference to the given pile
	/**
	 * Gets one of the seven main piles.
     * 
     * @param index which pile to be acceesed 
     * @return the pile at index
	 */
	public Stack<Card> getPile(int index)
	{
		return piles[index];
	}

	/**
	 * Creates an ArrayList containing each of the 52
	 * cards in a standard deck.
	 */
	private void createStock()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		// String[] suits = {"c", "d", "h", "s"};
		// for (int i = 0; i < suits.length; i++)
		// {
		// 	for (int j=1; j<=13; j++)
		// 	{
		// 		cards.add(new Card(j, suits[i]));
		// 	}
		// }

		// while (cards.size()>0)
		// {
		// 	int index = (int)(Math.random()*cards.size());
		// 	stock.push(cards.remove(index));
		// }

		for (int i = 1; i < 14; i++)
        {
            cards.add(new Card(i, "s")); 
        }
        for (int i = 1; i < 14; i++)
        {
            cards.add(new Card(i, "c")); 
        }
        for (int i = 1; i < 14; i++)
        {
            cards.add(new Card(i, "d")); 
        }
        for (int i = 1; i < 14; i++)
        {
            cards.add(new Card(i, "h")); 
        }
        while (cards.size() > 0)
        {
            stock.push(cards.remove((int)(Math.random()*cards.size()))); 
        }
	}

	/**
	 * Deals cards from the stock to the 7 piles 
	 * in the arrangement shown in the picture earlier in the lab.  
	 */
	public void deal()
	{
		for (int i = 0; i < 7; i++)
        {
            for (int k = 0; k <= i; k++)
            {
                if (!stock.isEmpty())
                {
                    Card a = stock.remove(0);
                    if (k == i)
                    {
                        a.turnUp();
                    }
                    piles[i].add(a);
                }
            }
        }
	}

	/**
	 * Moves the top three cards from the stock onto the top of the waste.  
	 * If there are fewer than three cards on the stock, transfers whatever is left to the waste. 
	 */
	public void dealThreeCards()
	{
		for (int i = 0; i < 3; i++)
        {
            if (!stock.isEmpty())
            {
                Card c = stock.pop();
                c.turnUp();
                waste.push(c);
            }
        }
	}

	/**
	 * repeatedly moves the top card from the waste to the top of the stock, 
	 * until there are no cards remaining in the waste.  
	 */
	public void resetStock()
	{
		while (!waste.isEmpty())
        {
            Card c = waste.pop();
            c.turnDown();
            stock.push(c);
        }
	}

	//called when the stock is clicked
	/**
	 * tests if the stock has any cards left.  If so, transfer three cards to the waste, 
	 * and otherwise reset the stock, using the helper methods you just wrote.
	 */
	public void stockClicked()
	{
		if (display.isPileSelected() || display.isWasteSelected())
            return;
        
        else if (!stock.isEmpty())
            dealThreeCards();
        
        else resetStock();
               
	}

	//called when the waste is clicked
	/**
	 * Selects the waste if it is not empty and neither the waste nor a pile is already selected. 
	 * Unselect the waste if it is already selected.
	 */
	public void wasteClicked()
	{
		if(!waste.isEmpty() && !display.isWasteSelected() && !display.isPileSelected())
		{
            display.selectWaste();
		}
        
		else if (display.isWasteSelected())
		{
            display.unselect(); 
		}
		System.out.println("waste clicked");
	}

	//precondition:  0 <= index < 4
	//called when given foundation is clicked
	/**
     * This method gets called when one of the foundations are clicked.
     * Tries to add a card from the pile or the waste to foundation pile
     * 
     * @param index the index of the foundations array
     * 
     */
	public void foundationClicked(int index)
	{
		if (display.isPileSelected())
        {
            if (!piles[display.selectedPile()].isEmpty() && 
                canAddToFoundation(piles[display.selectedPile()].peek(), index))
            {
                foundations[index].push(piles[display.selectedPile()].pop());
                display.unselect(); 
            }
        }
        else if (!waste.isEmpty() && display.isWasteSelected())
        {
            if (canAddToFoundation(waste.peek(), index))
            {
                foundations[index].push(waste.pop());
                display.unselect(); 
            }
        }

		System.out.println("foundation #" + index + " clicked");
	}

	//precondition:  0 <= index < 7
	//called when given pile is clicked
	/**
	 * When waste is selected, clicking on 
     * a pile will move the card from waste to the selected pile if legal.
	 * 
	 * @param index the index of piles array
	 */
	public void pileClicked(int index)
	{
		if (display.isWasteSelected() && canAddToPile(waste, index))
        {
            piles[index].push(waste.pop());
            display.unselect(); 
        }
        else if (!display.isWasteSelected() && !display.isPileSelected() && !piles[index].isEmpty())
        {
            if(!piles[index].peek().isFaceUp())
            {
                Card faceDown = piles[index].pop();
                faceDown.turnUp();
                piles[index].push(faceDown);
            }
            else
                display.selectPile(index); 
        }
        else if (display.selectedPile() != index && display.selectedPile() != -1)
        {
            Stack<Card> faceUp = removeFaceUpCards(display.selectedPile());
            if (canAddToPile(faceUp, index))
            {
                addToPile(faceUp, index);
                display.unselect();
            }
            else
            {
                addToPile(faceUp, display.selectedPile());
            }
        }
        else if (display.selectedPile() == index)
        {
            display.unselect();
        }
		System.out.println("pile #" + index + " clicked");

		
	}

	/**
	 * Returns true if the given card can be
	 * legally moved to the top of the given pile
	 * @param card the given card to be moved
	 * @param index the given pile
	 * @return true if the given card can be moved
	 */
	private boolean canAddToPile(Stack<Card> cards, int index)
    {
        if(cards.isEmpty())
        {
            return false;
        }
        
        if (piles[index].isEmpty())
            return cards.peek().getRank() == 13;
        Card top = piles[index].peek();
        Card card = cards.peek();
        if (top.isRed())
            return (!card.isRed() && (card.getRank() == top.getRank() - 1) && top.isFaceUp());
        return (card.isRed() && (card.getRank() == top.getRank() - 1) && top.isFaceUp());
    }

	/**
	 * Removes all face-up cards on the top of
	 * the given pile; returns a stack
	 * containing these cards
	 * @param index the index of the given pile
	 * @return the stack containing these cards
	 */
	private Stack<Card> removeFaceUpCards(int index)
	{
		Stack<Card> result = new Stack<Card>();
        while(!piles[index].isEmpty() && piles[index].peek().isFaceUp())
        {
            result.push(piles[index].pop());
        }
        return result;
	}

	//precondition:  0 <= index < 7
	//postcondition: Removes elements from cards, and adds
	//               them to the given pile.
	/**
	 * Removes elements from cards, and adds them to the given pile.
	 * @param cards the cards that might get added
	 * @param index the index of the pile to be added
	 */
	private void addToPile(Stack<Card> cards, int index)
	{
		while (!cards.isEmpty())
		{
			piles[index].push(cards.pop());
		}
	}

	/**
	 * Returns true if the given card can be
	 * legally moved to the top of the given
	 * foundation
	 * @param card the given card
	 * @param index the index of the given foundation
	 * @return true if the given card can be moved to the top of the given foundation
	 */
	private boolean canAddToFoundation(Card card, int index)
	{
		if(foundations[index].isEmpty())
        {
            return (card.getRank() == 1); //only an Ace can be added to an empty foundation
        }
        else 
        {
            int rank = getFoundationCard(index).getRank();
            String firstSuit = getFoundationCard(index).getSuit();
            if (card.getRank() == rank + 1)
            {
                if (card.getSuit().equals(firstSuit))
                {
                    return true;
                }
            }
            return false;
        }
	}

}
