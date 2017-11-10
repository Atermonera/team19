package models;

import java.util.ArrayList;
import java.util.Collections;


public class Stack{
	
	// Internal Variables
	protected java.util.List<Card> stack;

	// Constructor
	public Stack(){
		stack = new ArrayList<>();	
	}
	
	// Push/pop
	public void push(Card newCard){
		stack.add(newCard);
		return;
	}
	
	public Card pop(){
		return stack.remove(stack.size()-1);
	}
	
	// Peek?
	
	public int getSize(){
		return stack.size();
	}
}