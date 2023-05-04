package model.observer;

import java.util.ArrayList;

/**
 * observer abstract class which add and notify the observers added.
 */
public abstract class Observer {
  private ArrayList<Subject> observers = new ArrayList<Subject>();

  public void addObserver(Subject observer) {
    observers.add(observer);
  }
  
  /**
  * notifays every observer.
  */
  public void notisObserver() {
    for (Subject c : observers) {
      c.notis();
    }
  }

}