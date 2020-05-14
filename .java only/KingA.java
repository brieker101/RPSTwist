
/**
 * Write a description of class KingA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingA extends King
{
    
    public KingA()
    {
      
    }

    public void getEffect(Player winner, Player target){
        target.setHealth(target.getHealth()-2);
        winner.getHand().add(winner.drawCard(winner.getDeck()));
        target.setThrowBlock(true);
    }
}
