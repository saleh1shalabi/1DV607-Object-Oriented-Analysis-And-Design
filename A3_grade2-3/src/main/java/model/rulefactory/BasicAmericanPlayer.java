package model.rulefactory;

import model.rules.AmericanNewGameStrategy;
import model.rules.BasicHitStrategy;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.PlayerWinStrategy;
import model.rules.WinStrategy;


/**
* of the name it shows the rules and strategy of the game.
*/
public class BasicAmericanPlayer implements FactoryOfRules {

  @Override
  public HitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  @Override
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  @Override
  public WinStrategy getWinStrategy() {
    return new PlayerWinStrategy();
  }
  
  
}
