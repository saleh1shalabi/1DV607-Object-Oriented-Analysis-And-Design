package controller;

import model.visitor.GameVisit;
import view.View;

/**
 * of the name it shows the rules and strategy of the game.
 */
public class RuleShower implements GameVisit {
  
  private View view;

  RuleShower(View view) {
    this.view = view;
  }


  @Override
  public void american() {
    view.american();
  
  }

  @Override
  public void international() {
    view.international();
  }

  @Override
  public void basic() {
    view.basic();
   
  }


  @Override
  public void dealer() {
    view.dealer();
    
  }

  @Override
  public void player() {
    view.player();
;
  }

  @Override
  public void soft() {
    view.soft();
 
  }

  @Override
  public void empty() {
    view.empty();
  }
}
