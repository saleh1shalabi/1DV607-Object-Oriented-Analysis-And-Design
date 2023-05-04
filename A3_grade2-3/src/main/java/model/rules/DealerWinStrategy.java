package model.rules;

import model.Player;
import model.visitor.GameVisit;


/**
* A way of play that dealer have the advantage of winning.
*/
public class DealerWinStrategy implements WinStrategy {

  /**
  * compares scors.
  */
  @Override
  public boolean whoWins(Player dealer, Player player) {

    if (player.calcScore() > player.getMaxScore()) {
      return true;
    } else if (dealer.calcScore() > player.getMaxScore()) {
      return false;
    }
    return dealer.calcScore() >= player.calcScore();
  }

  @Override
  public void accept(GameVisit visitor) {
    visitor.empty();
    visitor.dealer();
    visitor.empty();
    
  }
}