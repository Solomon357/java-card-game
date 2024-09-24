import cards.Card;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {

    CardGame snap = new CardGame("Snap");

    snap.sortDeckIntoSuits();
    System.out.println("Sorted deck into suits: " + snap.getDeck());

    snap.sortDeckInNumberOrder();
    System.out.println("Sorted deck in number order: " + snap.getDeck());

    snap.shuffleDeck();
    System.out.println("shuffled in random order" + snap.getDeck());

    Card myCard = snap.dealCard();
    System.out.println("card dealt: " + myCard.toString());
  }
}