package model.rulefactory;

import model.rules.AmericanNewGameStrategy;
import model.rules.DealerWinStrategy;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.SoftStrategy;
import model.rules.WinStrategy;


/**
 * Creates concrete rules.
 */
public class SoftAmericanDealer implements FactoryOfRules {

  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  @Override
  public HitStrategy getHitRule() {
    return new SoftStrategy();
  }

  /**
   * Crates the rule to use when starting a new game.

   * @return The rule to use.
   */
  @Override
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  @Override
  public WinStrategy getWinStrategy() {
    return new DealerWinStrategy();
  }

}