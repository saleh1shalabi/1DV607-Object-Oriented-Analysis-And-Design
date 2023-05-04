package model.visitor;


/**
* visitor interface that implements in view.
*/
public interface GameVisit {

  void american();

  void international();

  void basic();

  void soft();

  void dealer();

  void player();

  void empty();
}
