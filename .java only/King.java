
/**
 Throw
 Win = 1 Damage, Beats Blocks
 Special Throws: 3 of Each
    If lands opponent cannot play a block next turn, draw a card and + 1 damage.
    If lands opponent cannot play an attack next turn and + 2 life.
    If lands opponent cannot play a throw next turn and look at their hand.
        -If opponent has zero legal plays. Opponent plays no card and automatically
        loses the next exchange.
 */
public class King extends Card
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class King
     */
    public King()
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
