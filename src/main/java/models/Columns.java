package models;

public class Columns{

	private Stack stacks[];

	public Columns(){
		stacks = new Stack[4];
	}

	public void deal(Card cards[]){
		if (cards.length != 4) {
			System.out.println("ERROR: attempted deal with other than 4 cards \n");
		}
		else {
			for (int i = 0; i < 4; i++) {
				this.stacks[i].push(cards[i]);
			}
		}
	}

	public void move(int col1, int col2){
	    //see if the topmost card of col1 is an ace and that col2 is empty
		Card movingCard = stacks[col1].peek();
		if (movingCard.value == 14 && stacks[col2].getSize() == 0){
			stacks[col2].push(stacks[col1].pop);//moveCard to empty column
		}
	}

	public Card remove(int col){
		// Try to remove the top card from col1	
		Card temp = new Card(1, Suit.H); // Just to get it to compile.
		if(stacks[col].getSize() > 0){
			return stacks[col].pop();
		}
		return temp;
	}
}