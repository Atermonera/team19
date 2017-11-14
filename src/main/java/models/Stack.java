package models;

import java.util.ArrayList;
import java.util.Collections;


public class Stack{
	
	// Internal Variables
	public int size;
	public java.util.ArrayList<Card> stack;

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

	public Card peek() {
		return stack.get(stack.size()-1);
	}

	public int getSize(){
		return stack.size();
	}
}
