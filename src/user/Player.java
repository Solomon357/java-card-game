package user;

public class Player{

  private static int playerObjectCount = 1;
  private final int playerId;

  public Player() {
    this.playerId = playerObjectCount;
    playerObjectCount++;
  }

  public int getPlayerId() {
    return playerId;
  }

  @Override
  public String toString() {
    return "Player " + getPlayerId();
  }
}
