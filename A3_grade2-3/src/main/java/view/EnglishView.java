package view;

import model.Card;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {
  private int input;


  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
  * Cleares the console.
  */
  public void clearScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
  }

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }

  }

  public int getsOrNah(int cardNumber, Iterable<Card> hand) {
    if (cardCounter(hand) > cardNumber) {
      System.out.println(toGetsOrNah() + cardCounter(hand) + ")");
      cardNumber = cardCounter(hand);
    } else {
      System.out.println("\n");
    }
    return cardNumber;
  }

  public String toGetsOrNah() {
    return "(gets card number ";
  } 


  @Override
  public Choies collectEvents() {
    input = getInput();
    Choies c = null;

    switch (input) {
      case 'p':  
        c = Choies.Play; 
        break;   
      case 'h': 
        c = Choies.Hit; 
        break; 
      case 's':
        c = Choies.Stand; 
        break; 
      case 'q':
        c = Choies.Quit; 
        break; 
      default:
        break;
    }
    return c;
  }


  @Override
  public int[] observ(int[] hands, Iterable<Card> dealerHand, Iterable<Card> playerHand) {
    System.out.print("Player: ");
    hands[0] = getsOrNah(hands[0], playerHand);
    cardPrinter(playerHand);

    System.out.print("Dealer: ");
    hands[1] = getsOrNah(hands[1], dealerHand);
    cardPrinter(dealerHand);

    System.out.println("\n----------------------\n");
    return hands;
  }

  private void cardPrinter(Iterable<Card> hand) {
    int x = 0;
    for (model.Card c : hand) {
      x++;
      System.out.print(x + ". ");
      displayCard(c);
    }
    System.out.println("\n");
  }

  private int cardCounter(Iterable<Card> hand) {
    int x = 0;
    for (model.Card c : hand) {
      x++;
    }
    return x;
  }



  @Override
  public void empty() {
    System.out.println();
  }

  @Override
  public void american() {
    System.out.println("Game:  American");
  }

  @Override
  public void international() {
    System.out.println("Game:  International");
  }

  @Override
  public void basic() {
    System.out.println("Hit:  Basic");
  }

  @Override
  public void dealer() {
    System.out.println("Win:  Dealer Advantage");
  }

  @Override
  public void player() {
    System.out.println("Win:  Player Advantage");
  }

  @Override
  public void soft() {

    System.out.println("Hit:  Soft-17");
  }

}
