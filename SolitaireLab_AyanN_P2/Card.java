/**
 * Describes the real life playing card, having suite and value!
 */
public class Card 
{
    private int rank;
    private String suit;
    boolean isFaceUp;

    /**
     * Constructor for objects of class Card.
     * 
     * @param r  the rank 
     * @param s  the suite
     */
    public Card(int rank, String suit)
    {
        isFaceUp = false;
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * returns rank of the card.
     * 
     * @return the rank 
     */
    public int getRank()
    {
        return rank;
    }

     /**
     * returns suit of the card.
     * 
     * @return the suit 
     */
    public String getSuit()
    {
        return suit;
    }

    /**
     * Checks to see if the card is red: hearts or diamonds
     * 
     * @return true if the card is red; otherwise, 
     *         false
     */
    public boolean isRed()
    {
        if (suit.equals("d") || suit.equals("h"))
            return true;

        else return false;
    }

    /**
     * Checks to see if the card is face up. 
     * 
     * @return true if card is face up; otherwise, 
     *         false
     */
    public boolean isFaceUp()
    {
        return isFaceUp;
    }

    /**
     * Faces the card up
     */
    public void turnUp()
    {
        isFaceUp = true;
    }

    /**
     * Faces the card down
     */
    public void turnDown()
    {
        isFaceUp = false;
    }

    /**
     * gets the fileName gif for a card
     * @return the file name
     */
    public String getFileName()
    {
        if (!isFaceUp)
        {
            return "cards/back.gif";
        }

        if (rank == 1)
            return "cards/a" + suit + ".gif";

        if (rank == 10)
            return "cards/t" + suit + ".gif";

        if (rank == 11)
            return "cards/j" + suit + ".gif";

        if (rank == 12)
            return "cards/q" + suit + ".gif";

        if (rank == 13)
            return "cards/k" + suit + ".gif";

        else return "cards/" + rank + suit + ".gif";

    }
}
