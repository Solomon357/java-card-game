import cards.Card;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {



    Card myCard = new Card("spade", "J");
    System.out.println(myCard.toString());

    CardGame snap = new CardGame("Snap");

    System.out.println(snap.getDeck());
    System.out.println(snap.getCurrentDeckLength());
  }
}