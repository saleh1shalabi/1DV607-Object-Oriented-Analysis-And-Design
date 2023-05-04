package model.rules;

import model.Card;
import model.Card.Value;
import model.Player;
import model.visitor.GameVisit;

/**
* new rule of play.
*/
public class SoftStrategy implements HitStrategy {
  
  private static final int score = 17;
  
  /**
  * looks and compars dealer hand if he gets a new card.
  */
  @Override
  public boolean doHit(Player dealer) {
    boolean toRet = false;
    int sc = dealer.calcScore();
    if (sc < score) {
      toRet = true;
    }
    if (sc == score) {
      for (Card c : dealer.getHand()) {
        if (c.getValue() == Value.Ace) {
          if (sc + 10 == score) {
            toRet = true;
          }
        }
      }
    }
    return toRet;       
  }

  @Override
  public void accept(GameVisit visitor) {
    visitor.empty();
    visitor.soft();
    visitor.empty();
  }
}



