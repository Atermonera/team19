package models;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

// Spanish Deck
public class DeckEs extends Stack{
	public DeckEs(){
		stack = new ArrayList<>();
		for(int i=1; i < 12; i++) {
			stack.add(new Card(i, Suit.EsCl));
			stack.add(new Card(i, Suit.EsCo));
			stack.add(new Card(i, Suit.EsCu));
			stack.add(new Card(i, Suit.EsSw));
		}
		stack.add(new Card(13, Suit.J));
		stack.add(new Card(13, Suit.J));
	
		long seed = System.nanoTime();
		Collections.shuffle(stack, new Random(seed));
	}
}
