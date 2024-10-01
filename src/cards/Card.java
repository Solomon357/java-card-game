package cards;

public class Card {

  private final char suit;
  private final String symbol;
  private final Integer value;

  public Card(char suit, String key){
    this.suit = suit;
    this.value = CardUtils.getCardValueMap().get(key);
    this.symbol = key;
  }

  public char getSuit() {
    return suit;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "\n Card{" +
            "suit='" + suit + '\'' +
            ", symbol='" + symbol + '\'' +
            ", value=" + value +
            '}' + '\n';
  }
}
