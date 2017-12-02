package models;

import static models.Suit.J;

public class Game {

	public Stack deck, discard;
	public Stack[] cols;

	public Game() {
		new Game(0);
	}
	
    public Game(int DeckType) {
		// Constructor
		//deck = new Deck();
		switch(DeckType){
			case 0:
				deck = new DeckStd();
				break;
			
			case 1:
				deck = new DeckEs();
				break;
		}
		
		cols = new Stack[4];
		for(int i = 0; i < 4; i++)
			cols[i] = new Stack();
		discard = new Stack();
		// Deal the first four cards in here, that's part of initial state
		this.dealFour();
	}
	
    public void dealFour() {
		// Pop four cards from deck and pass them to cols to push
		if(deck.getSize() > 3){
			for(int i = 0; i < 4; i++)
				cols[i].push(deck.pop());
		} else {
			// deal until it's empty
			for(int i = deck.getSize(); i > 0; i--)
				cols[3-i].push(deck.pop());
		}
		return;
    }
	
    public void remove(int columnNumber) {
		int jokerloc = -1; //Holds the column number of the joker, -1 if not found
		for (int i = 0; i < 4; i++){
			if (cols[i].peek().suit == J){
				jokerloc = i;
			}
			//If this column is not empty and it is not the column being removed, check to see
			// if the suits are equal and the values are greater than the removed card
			if (i != columnNumber && cols[columnNumber].getSize() > 0
					&& cols[i].getSize() > 0
					&& cols[columnNumber].peek().suit == cols[i].peek().suit
					&& cols[columnNumber].peek().value < cols[i].peek().value){
				discard.push(cols[columnNumber].pop());
				return; //this is bounce out of remove() and not check jokerloc
				//if doesn't work, then it will delete Joker & [colNumber] twice
			}
		}if(jokerloc != -1){
			discard.push(cols[columnNumber].pop());
			discard.push(cols[jokerloc].pop());
		}
	}

    public void move(int columnFrom, int columnTo) {
	    //see if the topmost card of col1 is an ace and that col2 is empty
		Card movingCard = cols[columnFrom].peek();
		if (movingCard.value == 14 && cols[columnTo].getSize() == 0)
			cols[columnTo].push(cols[columnFrom].pop());//moveCard to empty column
		return;
    }
	
	public void customDeal(Card A, Card B, Card C, Card D){
		cols[0].push(A);
		cols[1].push(B);
		cols[2].push(C);
		cols[3].push(D);
		return;
	}
}
