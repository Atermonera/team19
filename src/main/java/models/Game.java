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
		for (int i = 0; i < 4; i++){
			//If this column is not empty and it is not the column being removed, check to see
			// if the suits are equal and the values are greater than the removed card
			if (i != columnNumber && cols[columnNumber].getSize() > 0
					&& cols[i].getSize() > 0
					&& cols[columnNumber].peek().suit == cols[i].peek().suit
					&& cols[columnNumber].peek().value < cols[i].peek().value){
				discard.push(cols[columnNumber].pop());
				break;
			}
		}
    }

    public void move(int columnFrom, int columnTo) {
	    //see if the topmost card of col1 is an ace and that col2 is empty
		Card movingCard = cols[columnFrom].peek();
		if (movingCard.value == 14 && cols[columnTo].getSize() == 0)
			cols[columnTo].push(cols[columnFrom].pop());//moveCard to empty column
		return;
    }
}
