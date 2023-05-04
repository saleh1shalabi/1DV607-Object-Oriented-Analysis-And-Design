package view;

/**
 * Implements a Swedish console view.
 */
public class SwedishView extends EnglishView {

  /**
   * Shows a welcome message.
   */
  @Override
  public void displayWelcomeMessage() {
    clearScreen();
    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
    System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
  }

  /**
   * Displays a card.

   * @param card The card to display.
   */
  @Override
  public void displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("Dolt Kort");
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio",
                          "knekt", "dam", "kung", "ess" };
      System.out.println("" + colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()]);
    }
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  @Override
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("Croupiern Vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  @Override
  public String toGetsOrNah() {
    return "(Får kortnummer ";
  }


  @Override
  public void american() {
    System.out.println("Spel:  Amrikanskt");
  }

  @Override
  public void international() {
    System.out.println("Spel:  Internationellt");
  }

  @Override
  public void basic() {
    System.out.println("Kort Dragnings Metod:  Normal");
  }

  @Override
  public void dealer() {
    System.out.println("vinst:  Croupierns Övertag");
  }

  @Override
  public void player() {
    System.out.println("vinst:  Spelare Övertag");
  }

  @Override
  public void soft() {
    System.out.println("Kort Dragnings Metod:  Soft-17 regel");
  }

}
