package cardgames;

import cards.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame{

  private final ArrayList<Card> snapDeck;

  public Snap(String name){
    super(name);
    this.snapDeck = new ArrayList<>();
    System.out.println("Welcome to the Snap game!");
  }

  public Card takeTurn(Card PlayerCard, String input){
    snapDeck.add(PlayerCard);
    return PlayerCard;
  }

  public void playSnap() {
    Scanner input = new Scanner(System.in);
    System.out.println("Press Enter to deal card");
    input.nextLine();

    snapDeck.add(dealCard());
    System.out.println("Current SnapDeck "+ getSnapDeck());
    while(true){
      System.out.println("Press Enter to deal another card");
      input.nextLine();

      snapDeck.add(dealCard());
      System.out.println("Last Cards: " + getLastCards());

      if(snapDeck.getLast().getValue().equals(snapDeck.get(snapDeck.size()-2).getValue())){
        System.out.println("SNAP!! You win!");
        System.out.println("Winning Match! " + getLastCards());
        break;
      }
    }
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

}
