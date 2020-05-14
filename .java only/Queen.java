
/**
 Attack
  Win = 1 Damage, Beats Throws
  Special Attacks: 3 of Each
    If Attack Lands + 1 Damage and draw a card.
    If Attack Lands + 2 Damage.
    In all cases, discard your hand. If Attack Lands, + 1 damage for every 2 cards in
    hand discarded this way, rounded down.
 */
public class Queen extends Card
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Queen
     */
    public Queen()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int playCard(Object card)
    {
        // put your code here
        return 1;
    }
}
