package cards;

import java.util.HashMap;
import java.util.Map;

public class CardUtils {

  private static final Map<String,Integer> cardValueMap = new HashMap<>(Map.ofEntries(
          Map.entry("2", 2),
          Map.entry("3", 3),
          Map.entry("4", 4),
          Map.entry("5", 5),
          Map.entry("6", 6),
          Map.entry("7", 7),
          Map.entry("8", 8),
          Map.entry("9", 9),
          Map.entry("10", 10),
          Map.entry("J", 11),
          Map.entry("Q", 12),
          Map.entry("K", 13),
          Map.entry("A", 14)
  ));

  private static final String[] cardKeys = cardValueMap.keySet().toArray(new String[0]);

  public static String[] getCardKeys() {
    return cardKeys;
  }

  public static Map<String, Integer> getCardValueMap() {
    return cardValueMap;
  }
}
