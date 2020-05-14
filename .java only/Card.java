public class Card implements Playable
{
    private int damage;
    private int heal;
   
    public Card()
    {
        damage = 0;
        heal = 0;
    }
    //Card effects manipulation
    public int getDamage(){
        return damage;
    }
    public int getHeal(){
        return heal;
    }
    public void setDamage(int dmg){
        damage = damage + dmg;
    }
    public void setHeal(int hp){
        heal = heal + hp;
    }
    
    //Determines the type of cards and who wins
    public void playCard(Card card1, Card card2, Player p1, Player p2){
        if((card1 instanceof Queen&&card2 instanceof Queen)||
            (card1 instanceof Jack&&card2 instanceof Jack)||
            (card1 instanceof King&&card2 instanceof King)){
            System.out.println("Tie!");
            }
        else if(card1 instanceof Jack&&card2 instanceof Queen){
            System.out.println("Player 1 wins the duel!");
           if (card1 instanceof JackA){
            ((JackA)card1).getEffect(p1, p2);
           }
           else if (card1 instanceof JackB){
            ((JackB)card1).getEffect(p1, p2);
           }
           else if (card1 instanceof JackC){
            ((JackC)card1).getEffect(p1, p2);
           }
        }
        else if (card1 instanceof Jack&&card2 instanceof King){
            System.out.println("Player 2 wins the duel!");
             if (card2 instanceof KingA){
            ((KingA)card2).getEffect(p2, p1);
           }
           else if (card2 instanceof KingB){
            ((KingB)card2).getEffect(p2, p1);
           }
           else if (card2 instanceof KingC){
            ((KingC)card2).getEffect(p2, p1);
           }
        }
        else if (card1 instanceof Queen&&card2 instanceof Jack){
            System.out.println("Player 2 wins the duel!");
           if (card1 instanceof JackA){
            ((JackA)card2).getEffect(p2, p1);
           }
           else if (card1 instanceof JackB){
            ((JackB)card2).getEffect(p2, p1);
           }
           else if (card1 instanceof JackC){
            ((JackC)card2).getEffect(p2, p1);
           }
        }
        else if (card1 instanceof Queen&&card2 instanceof King){
            System.out.println("Player 1 wins the duel!");
           if (card1 instanceof QueenA){
            ((QueenA)card1).getEffect(p1, p2);
           }
           else if (card1 instanceof QueenB){
            ((QueenB)card1).getEffect(p1, p2);
           }
           else if (card1 instanceof QueenC){
            ((QueenC)card1).getEffect(p1, p2);
           }
        }
        else if (card1 instanceof King&&card2 instanceof Jack){
            System.out.println("Player 1 wins the duel!");
            if (card1 instanceof KingA){
            ((KingA)card1).getEffect(p1, p2);
           }
           else if (card1 instanceof KingB){
            ((KingB)card1).getEffect(p1, p2);
           }
           else if (card1 instanceof KingC){
            ((KingC)card1).getEffect(p1, p2);
           }
        }
        else if (card1 instanceof King&&card2 instanceof Queen){
            System.out.println("Player 2 wins the duel!");
            if (card1 instanceof QueenA){
            ((QueenA)card2).getEffect(p2, p1);
           }
           else if (card1 instanceof QueenB){
            ((QueenB)card2).getEffect(p2, p1);
           }
           else if (card1 instanceof QueenC){
            ((QueenC)card2).getEffect(p2, p1);
           }
        }
        else{
            System.out.println("How did you break this?");
        }        
    }
    //Blank method for inheritance
    public void getEffect(Player winner, Player target){}
}
