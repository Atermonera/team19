package models;

public class Game {

	public Deck deck;
	public Columns cols;
	public Stack discard;

    public Game() {
		// Constructor
		deck = new Deck();
		cols = new Columns();
		discard = new Stack();
		// Deal the first four cards in here, that's part of initial state
		dealFour();
	}

    public void dealFour() {
		// Pop four cards from deck and pass them to cols to push
		Card toPush[] = new Card[4];
		if(deck.getSize() > 3)
			for(int i = 0; i < 4; i++)
				toPush[i] = deck.pop();
			cols.deal(toPush);
		return;
    }

    public void remove(int columnNumber) {
        // Redirect the column number into cols
		discard.push(cols.remove(columnNumber));
		return;
    }

    public void move(int columnFrom, int columnTo) {
        // Redirect the column number into cols
		cols.move(columnFrom, columnTo);
		return;
    }
}
