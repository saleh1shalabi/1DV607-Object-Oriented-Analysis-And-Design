package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;
import model.visitor.GameVisit;

/**
 *  international rule of the game. 
 */
public class InternationalNewGameStrategy implements NewGameStrategy {

  /**
   * start new game.
   */
  public boolean newGame(Deck deck, Dealer dealer, Player player) {

    dealer.getNewCard(player, true);

    dealer.getNewCard(dealer, true);

    dealer.getNewCard(player, true);

    return true;
  }

  @Override
  public void accept(GameVisit visitor) {
    visitor.empty();
    visitor.international();
    visitor.empty();
  }
}