package models;

public class Game {

	public Deck deck;
	public Stack[] cols;
	public Stack discard;

    public Game() {
		// Constructor
		deck = new Deck();
		cols = new Stack[4];
		for(int i = 0; i < 4; i++)
			cols[i] = new Stack();
		discard = new Stack();
		// Deal the first four cards in here, that's part of initial state
		this.dealFour();
	}
	
    public void dealFour() {
		// Pop four cards from deck and pass them to cols to push
		if(deck.getSize() > 3)
        for(int i = 0; i < 4; i++)
			cols[i].push(deck.pop());
		return;
    }

    public void remove(int columnNumber) {
		if(cols[columnNumber].getSize() > 0)
			discard.push(cols[columnNumber].pop());
		return;

    }

    public void move(int columnFrom, int columnTo) {
	    //see if the topmost card of col1 is an ace and that col2 is empty
		Card movingCard = cols[columnFrom].peek();
		if (movingCard.value == 14 && cols[columnTo].getSize() == 0)
			cols[columnTo].push(cols[columnFrom].pop());//moveCard to empty column
		return;
    }
}
