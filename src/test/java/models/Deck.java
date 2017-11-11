package models;

import java.util.Random;

public class Deck extends Stack{
	public Deck(){
		// Constructor goes here.
	}

	// Leaving the shuffle function from the old Game in here. 
	// Similar syntax will probably be useful
/*	
	public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }
*/	
}