package models;

public class Game {

	public Deck deck;
	public Columns cols;
	public Stack discard;

    public Game(){
		// Constructor
		// Deal the first four cards in here, that's part of initial state
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++){
			// Pop 4 cards from deck, then send them to cols
        }
    }

    public void remove(int columnNumber) {
        // Redirect the column number into cols
    }

    public void move(int columnFrom, int columnTo) {
        // Redirect the column number into cols
    }
}
