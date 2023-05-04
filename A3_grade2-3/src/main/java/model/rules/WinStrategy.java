package model.rules;

import model.Player;
import model.visitor.GameVisit;

/**
 * Rule interface that encapsulates when a player (the dealer) should take more cards.
 */
public interface WinStrategy {
  
  /**
   * Checks if the player (dealer) should take more cards.

   * @param dealer the player to check.
   * @return True if the rule decided the player should take another card.
   */
  boolean whoWins(Player dealer, Player player);

  void accept(GameVisit visitor);
}