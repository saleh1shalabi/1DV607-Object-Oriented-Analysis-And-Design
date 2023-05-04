package controller;

import model.Game;
import model.rulefactory.BasicInterPlayer;
import model.rulefactory.FactoryOfRules;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.

  * @param args Not used.
  */
  public static void main(String[] args) {
    
    // FactoryOfRules ruleFactory = new BasicAmericanPlayer();    
    FactoryOfRules ruleFactory = new BasicInterPlayer();
    // FactoryOfRules ruleFactory = new SoftAmericanDealer();
    // FactoryOfRules ruleFactory = new SoftInterDealer();

    // there are 4 more rules that can be implemented
    // but we think the idea of how we implement it is showed
    
    
    Game g = new Game(ruleFactory);
    Player ctrl = new Player(g);

    while (ctrl.play()) {
      
    }
  }
}