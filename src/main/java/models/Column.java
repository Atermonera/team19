package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Column{
  public java.util.List<Card> stack = new ArrayList<>();
  public void pushCard(Card card){
    this.stack.add(card); 
  }
  public Card getTop(){
    return this.stack.get(this.stack.size() - 1);
  }
  public boolean hasCards(){
    if (this.stack.size() > 0){
      return true;
    }
    return false;
  }
  public void popCard(){
    this.stack.remove(this.stack.size() - 1);
  }
}