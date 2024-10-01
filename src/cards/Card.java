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

//  public String getSymbol() {
//    return symbol;
//  }
//
//  public void setSymbol(String symbol) {
//    this.symbol = symbol;
//  }

  public Integer getValue() {
    return value;
  }

  private String findSymbol(int val){
    for(String key: CardUtils.getCardKeys()){
      if(CardUtils.getCardValueMap().get(key).equals(val)){
        return key;
      }
    }
    return "key not found";
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
