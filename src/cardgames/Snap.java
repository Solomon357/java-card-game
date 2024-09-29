package cardgames;

import cards.Card;
import user.Player;

import java.util.*;

public class Snap extends CardGame{

  private final ArrayList<Card> snapDeck;
  private final ArrayList<Player> players;

  private final TimerTask task = new TimerTask() {
    @Override
    public void run() {
        System.out.println("Sorry! you didn't type \"snap\" fast enough! You lose!");
        System.exit( 0);
    }
  };

  public Snap(String name){
    super(name);
    this.snapDeck = new ArrayList<>();
    this.players = null;
    System.out.println("Welcome to the Snap game!");
  }

  public Snap(String name, int playerNum){
    super(name);
    this.snapDeck = new ArrayList<>();
    this.players = new ArrayList<>(playerNum);

    //populating playerArr with multiple players
    for(int i = 0; i < playerNum; i++){
      players.add(new Player());
    }

    System.out.println("Welcome to the Snap game!");
  }

  public ArrayList<Player> getPlayers(){
    return players;
  }

  public ArrayList<Card> getSnapDeck() {
    return snapDeck;
  }

  public ArrayList<Card> getLastCards() {
    ArrayList<Card> lastCards = new ArrayList<>(2);
    lastCards.add(snapDeck.get(snapDeck.size()-2));
    lastCards.add(snapDeck.getLast());
    return lastCards;
  }


  public void playSnap() {
    Scanner input = new Scanner(System.in);
    System.out.println("Press Enter to deal card");
    input.nextLine();
    try{
      snapDeck.add(dealCard());

      System.out.println("Current SnapDeck\n"+ getSnapDeck());

      while(true){
        System.out.println("Press Enter to deal another card");
        input.nextLine();

        snapDeck.add(dealCard());
        System.out.println("Last Cards:\n" + getLastCards());

        if(snapDeck.getLast().getValue().equals(snapDeck.get(snapDeck.size()-2).getValue())){
          Timer timer = new Timer();
          timer.schedule(task, 2*1000L);
          System.out.println("SNAP, type \"snap\" in the next 2 seconds!! ");
          String playerWin = input.nextLine();
          timer.cancel();

          if(playerWin.equals("snap")){
            System.out.println("SNAP!! You win!");
            System.out.println("Winning Match!\n" + getLastCards());
          } else{
            System.out.println("Sorry you didn't type \"snap\" correctly. You lose!");
          }

          break;
        }
    }
    }catch (NoSuchElementException e){
      System.err.println("All available cards have been dealt! Game Over");
      //return to userCommand main menu
    }
  }

  public void playSnap(int playerNum){
    Player currentPlayer = players.getFirst();
    int playerIndex = 0;
    Scanner input = new Scanner(System.in);

    System.out.println(currentPlayer + ", Press Enter to deal card");
    input.nextLine();

    try{
      snapDeck.add(dealCard());

      System.out.println("Current SnapDeck "+ getSnapDeck());
      while(true){
        playerIndex++;
        if(playerIndex >= playerNum){
          playerIndex = 0;
        }

        currentPlayer = players.get(playerIndex);
        System.out.println(currentPlayer.toString() + ", Press Enter to deal another card");
        input.nextLine();

        snapDeck.add(dealCard());
        System.out.println("Last Cards: " + getLastCards());

        if(snapDeck.getLast().getValue().equals(snapDeck.get(snapDeck.size()-2).getValue())){

          System.out.println("SNAP!! " + currentPlayer.toString() + " wins!");
          System.out.println("Winning Match! " + getLastCards());
          break;
        }
      }
    } catch (NoSuchElementException e){
      System.err.println("All available cards have been dealt! Game Over");
      //return to userCommand main menu
    }
  }
}
