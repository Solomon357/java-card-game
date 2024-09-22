import cards.Card;
import cards.CardUtils;

import java.util.ArrayList;

public class CardGame {

  private final ArrayList<Card> deckOfCards = new ArrayList<>(52);
  private String name;
  public CardGame(String name){
    this.name = name;

    char[] suits = {'❤', '♠', '♦', '♣'};

    for (char suit : suits) {
      for (int j = 0; j < 13; j++) {
        this.deckOfCards.add(new Card(suit, CardUtils.getCardKeys()[j]));
      }
    }

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Card> getDeck() {
    return deckOfCards;
  }

  public int getCurrentDeckLength(){
    return deckOfCards.size();
  }
}
