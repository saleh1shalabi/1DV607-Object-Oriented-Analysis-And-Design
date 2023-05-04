package model.rulefactory;

import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;


/**
* interface to implement defferint rules.
*/
public interface FactoryOfRules {
  
  HitStrategy getHitRule();

  NewGameStrategy getNewGameRule();
  
  WinStrategy getWinStrategy();

}
