package controller;

import model.Game;
import model.observer.Subject;
import model.visitor.GameVisit;
import view.Choies;
import view.EnglishView;
import view.SwedishView;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player implements Subject {

  private Game game;
  private View view;
  private GameVisit showRules;

  // this array will save how many cards do both player and dealer have in hand.
  int[] hands = {0, 0};

  /**
   * Constructor.
   */
  public Player(Game g) {
    this.game = g;
    // the find bugs did not acept sending the view throw the instuctor.
    // we needed to move it from game and create it here to avoid code quality issu.

    // this.view =  new SwedishView();
    this.view = new EnglishView();
    
    game.newObserver(this);
    showRules = new RuleShower(view);
  }

  /**
   * Runs the play use case.

   * @return True as long as the game should continue.
   */
  public boolean play() {

    view.displayWelcomeMessage();

    game.getRules().getHitRule().accept(showRules);
    game.getRules().getNewGameRule().accept(showRules);
    game.getRules().getWinStrategy().accept(showRules);

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    Choies input  = view.collectEvents();

    if (input == Choies.Play) {
      cleareHands();
      game.newGame();
    } else if (input == Choies.Hit) {
      game.hit();
    } else if (input == Choies.Stand) {
      game.stand();
    }

    return input != Choies.Quit;
  }


  /**
   * what should be done when notis.
   */
  @Override
  public void notis() { 
    hands = view.observ(hands, game.getDealerHand(), game.getPlayerHand());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    
  }


  private void cleareHands() {
    // we must cleare the number of card in hands before a new game
    hands[0] = 0;
    hands[1] = 0;
  }
}