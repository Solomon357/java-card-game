import cardgames.CardGame;
import cardgames.Snap;
import cards.Card;
import user.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {

    Snap snap = new Snap("snap");

//    Player john = new Player();
//    Player dave = new Player();
//    System.out.println(john.toString());
//    System.out.println(dave.toString());

    snap.shuffleDeck();

    snap.playSnap();


//    CardGame snap = new CardGame("Snap");
//
//    snap.sortDeckIntoSuits();
//    System.out.println("Sorted deck into suits: " + snap.getDeck());
//
//    snap.sortDeckInNumberOrder();
//    System.out.println("Sorted deck in number order: " + snap.getDeck());
//
//    snap.shuffleDeck();
//    System.out.println("shuffled in random order" + snap.getDeck());
//
//    Card myCard = snap.dealCard();
//    System.out.println("card dealt: " + myCard.toString());
  }
}