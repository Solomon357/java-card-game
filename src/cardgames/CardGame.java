package cardgames;

import cards.Card;
import cards.CardUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

  private ArrayList<Card> deckOfCards = new ArrayList<>(52);
  private String name;

  public CardGame(String name){
    this.name = name;

    char[] suits = {'❤', '♠', '♦', '♣'};
   // Suits[] suits = Suits.values();

    for (char suit : suits) {
      for (int i = 0; i < 13; i++) {
        this.deckOfCards.add(new Card(suit, CardUtils.getCardKeys()[i]));
      }
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Card dealCard(){

    Card firstCard = deckOfCards.getFirst();
    deckOfCards.removeFirst();
    return firstCard;
  }

  public ArrayList<Card> sortDeckInNumberOrder() {
    ArrayList<Card> sortedDeck = deckOfCards;
    sortedDeck.sort(Comparator.comparing(Card::getValue));
    this.deckOfCards = sortedDeck;
    return sortedDeck;
  }

  public ArrayList<Card> shuffleDeck(){
    ArrayList<Card> shuffledDeck = deckOfCards;
    Collections.shuffle(shuffledDeck);
    return shuffledDeck;
  }

  public ArrayList<Card> sortDeckIntoSuits() {
    ArrayList<Card> sortedSuitDeck = deckOfCards;

    sortedSuitDeck.sort(Comparator.comparing(Card::getValue));
    sortedSuitDeck.sort(Comparator.comparing(Card::getSuit));

    this.deckOfCards = sortedSuitDeck;
    return sortedSuitDeck;
  }

  public ArrayList<Card> getDeck() {
    return deckOfCards;
  }

  public int getCurrentDeckLength(){
    return deckOfCards.size();
  }
}
