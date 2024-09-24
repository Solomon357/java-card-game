package cards;

import java.util.HashMap;

public class CardUtils {

  private static final HashMap<String,Integer> cardValueMap = new HashMap<>(){{
    put("2", 2);
    put("3", 3);
    put("4", 4);
    put("5", 5);
    put("6", 6);
    put("7", 7);
    put("8", 8);
    put("9", 9);
    put("10", 10);
    put("J", 11);
    put("Q", 12);
    put("K", 13);
    put("A", 14);
  }};

  private final char[] suits = {'❤', '♠', '♦', '♣'};

  private static final String[] cardKeys = cardValueMap.keySet().toArray(new String[0]);

  public char[] getSuits() {
    return suits;
  }

  public static String[] getCardKeys() {
    return cardKeys;
  }

  public static HashMap<String, Integer> getCardValueMap() {
    return cardValueMap;
  }
}
