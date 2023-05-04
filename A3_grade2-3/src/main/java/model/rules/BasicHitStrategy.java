package model.rules;

import model.Player;
import model.visitor.GameVisit;

/**
 * the Basic hit strategy. 
 */
public class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }

  @Override
  public void accept(GameVisit visitor) {
    visitor.empty();
    visitor.basic();
    visitor.empty();
  }
}