package model.rules;

import model.Player;
import model.visitor.GameVisit;

/**
* A way of play that player have the advantage of winning.
*/
public class PlayerWinStrategy implements WinStrategy {


  /**
  * compars Scors.
  */
  @Override
  public boolean whoWins(Player dealer, Player player) {
    int playerScore = player.calcScore();
    int dealerScore = dealer.calcScore();
    int maxScore = player.getMaxScore();
    if (dealerScore > maxScore) {
      return false;
    } else if (playerScore > maxScore) {
      return true;
    }  else if (playerScore == dealerScore) {
      if (playerScore == maxScore) {
        return false;
      } else {
        if (maxScore - playerScore > maxScore - dealerScore) {
          return true;
        }
      }
      return false;
    } else if (playerScore != dealerScore) {
      return playerScore < dealerScore;
    }
    return true;
  }

  @Override
  public void accept(GameVisit visitor) {
    visitor.empty();
    visitor.player();
    visitor.empty();
  }
  
}