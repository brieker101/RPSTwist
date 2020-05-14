import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private int cards = 27;
    private int graveyard = 0;
    private int life;
    private int turn;
    private int sentinel;
    private boolean throwBlock;
    private boolean blockBlock;
    private boolean attackBlock;
    private String name;
    private Card p1Selection;
    private Card p2Selection;
    ArrayList<Card> deck;
    ArrayList<Card> hand;
    ArrayList<Card> transfer;
    Game core = new Game();
    Scanner in = new Scanner(System.in);
    
    public Player(String playerName)
    {   //Sets up player stats and fills deck with cards
        life = 10;
        name = playerName;
        ArrayList<Card> deck = new ArrayList<Card>(27);
        for (int i = 0;i<26;i++){
            deck.add(fillDeck(i));
        }
        ArrayList<Card> hand = new ArrayList<Card>(27);
        graveyard = 0;
        //Card effects that block uses
        throwBlock = false;
        blockBlock = false;
        attackBlock= false;
    }
    
    //used for the steal card effect
    public void addTransfer(Card card){transfer.add(card);}
    
    public void getTransfer(){transfer.get(transfer.size()-1);}
    
    //random card draw that accounts for diminishing deck count
    public Card drawCard(ArrayList<Card> deck){
        int selector = (int)Math.random()*26;
        Card returner = new Card();
        //deck.remove();
        graveyard++;
        return returner;
    }
    
    //getters and setters
    public Card getCard(int i){return hand.get(i);}
    
    public boolean getAttackBlock(){return attackBlock;}
    
    public boolean getBlockBlock(){return blockBlock;}
    
    public boolean getThrowBlock(){return throwBlock;}
    
    public void setAttackBlock(boolean A){attackBlock = A;}
    
    public void setBlockBlock(boolean B){blockBlock = B;}
    
    public void setThrowBlock(boolean T){throwBlock = T;}
    
    public int getDeckSize(ArrayList<Card> deck){return deck.size();}
    
    public ArrayList<Card> getDeck(){return deck;}
    
    public int getHandSize(){return hand.size();}
    
    public int getHealth(){return life;}
    
    public void setHealth(int heal){life = heal;}
    
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    //Fills deck with 3 of each card type
    public Card fillDeck(int i){
            KingA ka = new KingA();
            KingB kb = new KingB();
            KingC kc = new KingC();
            QueenA qa = new QueenA();
            QueenB qb = new QueenB();
            QueenC qc = new QueenC();
            JackA ja = new JackA();
            JackB jb = new JackB();
            JackC jc = new JackC();
            if(i>23){return ka;}
            else if(i>20){return kb;}
            else if(i>17){return kc;}
            else if(i>14){return qa;}
            else if(i>11){return qb;}
            else if(i>8){return qc;}
            else if(i>5){return ja;}
            else if(i>2){return jb;}
            else if(i>-1){return jc;}
            return jc;
        }
    
        //Starts game
    public void newGame(){
    
        System.out.println("Please enter Player 1's name:");
            name = in.nextLine();
            Player player1 = new Player(name);
        System.out.println("Please enter Player 2's name:");
            name = in.nextLine();
            Player player2 = new Player(name);
            for(int i=0;i<3;i++){
                player1.getHand().add(player1.drawCard(player1.getDeck()));
                player2.getHand().add(player2.drawCard(player2.getDeck()));
            }
            while(player1.getHealth()>0&&player2.getHealth()>0){
                turn(player1, player2);
            }
    
    }
    //method used for repeating turns
    public void turn(Player p1, Player p2){
        if(turn<1){}
        else{
            p1.getHand().add(p1.drawCard(deck));
            p2.getHand().add(p2.drawCard(deck));
        }
        while(!(sentinel>0)||!(sentinel<=p1.getHandSize())){
            sentinel = 0;
            System.out.println(p1 +" select your card:");
                p1.getHand();
                sentinel = in.nextInt();
                p1Selection = p1.getCard(in.nextInt());
                if(p1Selection instanceof Queen){
                    while(p1.getAttackBlock() == true){
                        System.out.println("That type of card is blocked!");
                        sentinel = -1;
                    }
                }
                if(p1Selection instanceof King){
                    while(p1.getThrowBlock() == true){
                        System.out.println("That type of card is blocked!");
                        sentinel = -1;
                    }
                }
                if(p1Selection instanceof Jack){
                    while(p1.getBlockBlock() == true){
                        System.out.println("That type of card is blocked!");
                        sentinel = -1;
                    }
                }
        }
        sentinel = 0;
        while(!(in.nextInt()>0)||!(in.nextInt()<=p2.getHandSize())){
            System.out.println(p2 +" select your card:");
            p2.getHand();
            sentinel = in.nextInt();
            p2Selection = p2.getCard(in.nextInt());
                if(p2Selection instanceof Queen){
                    while(p2.getAttackBlock() == true){
                        System.out.println("That type of card is blocked!");
                        sentinel = -1;
                    }
                }
                if(p2Selection instanceof King){
                    while(p2.getThrowBlock() == true){
                        System.out.println("That type of card is blocked!");
                        sentinel = -1;
                    }
                }
                if(p2Selection instanceof Jack){
                    while(p2.getBlockBlock() == true){
                        System.out.println("That type of card is blocked!");
                        sentinel = -1;
                    }
                }
        }
        Card newTurn = new Card();
        newTurn.playCard(p1Selection,p2Selection,p1,p2);
        
        p1.setAttackBlock(false);
        p1.setBlockBlock(false);
        p2.setThrowBlock(false);
        p2.setAttackBlock(false);
        p2.setBlockBlock(false);
        turn++;
    }
}


