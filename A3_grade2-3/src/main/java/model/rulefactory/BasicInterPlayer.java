package model.rulefactory;

import model.rules.BasicHitStrategy;
import model.rules.HitStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.NewGameStrategy;
import model.rules.PlayerWinStrategy;
import model.rules.WinStrategy;

/**
 * of the name it shows the rules and strategy of the game.
 */
public class BasicInterPlayer implements FactoryOfRules {
  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  @Override
  public HitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  /**
   * Crates the rule to use when starting a new game.

   * @return The rule to use.
   */
  @Override
  public NewGameStrategy getNewGameRule() {
    return new InternationalNewGameStrategy();
  }

  @Override
  public WinStrategy getWinStrategy() {
    return new PlayerWinStrategy();
  }
}
