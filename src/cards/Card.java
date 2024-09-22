package cards;

public class Card {

  private final char suit;
  private String symbol;
  private final int value;

  public Card(String suit, String key){
    switch (suit){
      case "heart":
        this.suit = '❤';
        break;
      case "spade":
        this.suit = '♠';
        break;
      case "diamond":
        this.suit = '♦';
        break;
      case "clover":
        this.suit = '♣';
        break;
      default:
        this.suit = 'n';
        break;
    }

    this.value = CardUtils.getCardValueMap().get(key);

    for(String keys: CardUtils.getCardKeys()){
      if(CardUtils.getCardValueMap().get(keys).equals(value)){
        this.symbol = keys;
      }
    }
  }

  public Card(char suit, String key){
    this.suit = suit;
    this.value = CardUtils.getCardValueMap().get(key);

    for(String keys: CardUtils.getCardKeys()){
      if(CardUtils.getCardValueMap().get(keys).equals(value)){
        this.symbol = keys;
      }
    }
  }


  public char getSuit() {
    return suit;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Card{" +
            "suit='" + suit + '\'' +
            ", symbol='" + symbol + '\'' +
            ", value=" + value +
            '}' + '\n';
  }
}
