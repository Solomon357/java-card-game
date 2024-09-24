package cards;

public class Card {

  private final char suit;
  private String symbol;
  private final Integer value;

  public Card(char suit, String key){
    this.suit = suit;
    this.value = CardUtils.getCardValueMap().get(key);
    this.symbol = findSymbol(value);
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

  public Integer getValue() {
    return value;
  }

  private String findSymbol(int val){
    for(String keys: CardUtils.getCardKeys()){
      if(CardUtils.getCardValueMap().get(keys).equals(val)){
        return keys;
      }
    }
    return "key not found";
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
