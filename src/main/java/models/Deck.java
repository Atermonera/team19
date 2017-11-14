package models;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Stack{
	public Deck(){
		stack = new ArrayList<>();
		for (int i=2; i < 15; i++) {
			stack.add(new Card(i, Suit.C));
			stack.add(new Card(i, Suit.H));
			stack.add(new Card(i, Suit.D));
			stack.add(new Card(i, Suit.S));
		}
		long seed = System.nanoTime();
		Collections.shuffle(stack, new Random(seed));
	}
}
