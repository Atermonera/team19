package models;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

// Standard Deck
public class DeckStd extends Stack{
	public DeckStd(){
		stack = new ArrayList<>();
		for (int i=2; i < 15; i++) {
			stack.add(new Card(i, Suit.StdC));
			stack.add(new Card(i, Suit.StdH));
			stack.add(new Card(i, Suit.StdD));
			stack.add(new Card(i, Suit.StdS));
		}
		long seed = System.nanoTime();
		Collections.shuffle(stack, new Random(seed));
	}
}