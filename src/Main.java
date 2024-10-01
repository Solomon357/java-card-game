import cardgames.Snap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void handleSnapGame(int input){
    if (input == 1) {
      Snap singlePlayerSnap = new Snap("snap");
      singlePlayerSnap.shuffleDeck();
      singlePlayerSnap.playSnap();
    } else {
      Snap multiPlayerSnap = new Snap("snap", input);
      multiPlayerSnap.shuffleDeck();
      multiPlayerSnap.playSnap(input);
    }
  }

  public static void main(String[] args) throws InterruptedException {

    System.out.println("Welcome to the Java Card Game Suite");
    System.out.println("We're playing Snap (more card games to be added)\n");
    TimeUnit.SECONDS.sleep(2);
    System.out.println("INSTRUCTIONS\n");
    TimeUnit.SECONDS.sleep(1);
    System.out.println(" * Press enter to play a random card from the card deck");
    System.out.println(" * The last 2 cards in play will be displayed for everyone to see");
    System.out.println(" * A snap opportunity will occur once the last 2 cards played have the same value");
    System.out.println(" * During a snap opportunity the current player has 2 seconds to type \"snap\"");
    System.out.println(" * If the current player fails to type snap then the NEXT player in rotation WINS");
    System.out.println(" * If you're playing single player snap and the player fails to type snap then the player loses\n");
    System.out.println(" Have fun :)\n");
    TimeUnit.SECONDS.sleep(2);

    Scanner input = new Scanner(System.in);

    int nextInput = 0;
    while(nextInput < 1){
      System.out.println("Please enter a valid number of players for Snap (1 or more)");

      try{
        nextInput = Math.max(Integer.parseInt(input.next()), 0);
      } catch (NumberFormatException e) {
        nextInput = -1;
      }
    }

    int userInput = nextInput;

    handleSnapGame(userInput);
  }
}