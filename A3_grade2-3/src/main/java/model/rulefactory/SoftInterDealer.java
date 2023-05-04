package model.rulefactory;

import model.rules.DealerWinStrategy;
import model.rules.HitStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.NewGameStrategy;
import model.rules.SoftStrategy;
import model.rules.WinStrategy;

/**
 * of the name it shows the rules and strategy of the game.
 */
public class SoftInterDealer implements FactoryOfRules {

  @Override
  public HitStrategy getHitRule() {
    return new SoftStrategy();
  }

  @Override
  public NewGameStrategy getNewGameRule() {
    return new InternationalNewGameStrategy();
  }

  @Override
  public WinStrategy getWinStrategy() {
    return new DealerWinStrategy();
  }
  
}
