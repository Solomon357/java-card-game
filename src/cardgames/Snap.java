package cardgames;

import cards.Card;
import user.Player;

import java.util.*;

public class Snap extends CardGame{

  private final ArrayList<Card> snapDeck;
  private final ArrayList<Player> players;
  protected int playerIndex = -1;

  private final TimerTask task = new TimerTask() {
    @Override
    public void run() {
      if(playerIndex < 0){
        singlePlayerTask();
      } else{
        multiPlayerTask();
      }
    }

    public void singlePlayerTask(){
      System.out.println("Sorry! you didn't type \"snap\" fast enough! You lose!");
      System.exit( 0);
    }


    public void multiPlayerTask() {
      if(playerIndex == getPlayers().size()-1){
        System.out.println("Sorry! you didn't type \"snap\" fast enough! " + getPlayers().getFirst() + " wins!");
        System.exit( 0);
      } else{
        System.out.println("Sorry! you didn't type \"snap\" fast enough! " + getPlayers().get(playerIndex+1) + " wins!");
        System.exit( 0);
      }
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

    System.out.println("Welcome to the Snap game with "+players.size()+ " Players!");
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
        System.out.println("Last Cards:\n" + getLastCards() + "\n");

        if(snapDeck.getLast().getValue().equals(snapDeck.get(snapDeck.size()-2).getValue())){
          Timer timer = new Timer();
          System.out.println("SNAP, type \"snap\" in the next 2 seconds!! ");
          timer.schedule(task, 2*1000L);
          String playerWin = input.nextLine();
          timer.cancel();

          handleWin(playerWin);
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
    playerIndex = 0;
    Scanner input = new Scanner(System.in);

    System.out.println(currentPlayer + ", Press Enter to deal card");
    input.nextLine();

    try{
      snapDeck.add(dealCard());

      System.out.println("Current SnapDeck "+ getSnapDeck() + "\n");
      while(true){
        playerIndex++;
        if(playerIndex >= playerNum){
          playerIndex = 0;
        }

        currentPlayer = players.get(playerIndex);
        System.out.println(currentPlayer.toString() + ", Press Enter to deal another card");
        input.nextLine();

        snapDeck.add(dealCard());
        System.out.println("Last Cards: " + getLastCards() + "\n");

        if(snapDeck.getLast().getValue().equals(snapDeck.get(snapDeck.size()-2).getValue())){
          Timer timer = new Timer();
          timer.schedule(task, 2*1000L);
          System.out.println(currentPlayer.toString().toUpperCase() +"! Type \"snap\" in the next 2 seconds to WIN!! ");
          String playerWin = input.nextLine();
          timer.cancel();

          handleWin(currentPlayer, playerWin);
          break;
        }
      }
    } catch (NoSuchElementException e){
      System.err.println("All available cards have been dealt! Game Over");
      //return to userCommand main menu
    }
  }
  public void handleWin(String input){
    if(input.equals("snap")){
      System.out.println("SNAP!! You win!");
      System.out.println("Winning Match!\n" + getLastCards());
    } else{
      System.out.println("Sorry you didn't type \"snap\" correctly. You lose!");
    }
  }

  public void handleWin(Player player, String input){
    if(input.equals("snap")){
      System.out.println("SNAP!! " + player.toString() + " wins!");
      System.out.println("Winning Match!\n" + getLastCards());
    } else{
      if(player.getPlayerId() == players.size()){
        System.out.println("Sorry! you didn't type \"snap\" correctly! " + players.getFirst() + " wins!");
      } else{
        System.out.println("Sorry! you didn't type \"snap\" correctly! " + players.get(player.getPlayerId()) + " wins!");
      }
    }
  }
}
