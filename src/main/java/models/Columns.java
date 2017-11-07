package models;

public class Columns{
	
	private Stack stacks[];
	
	public Columns(){
		// Constructor
	}
	
	public void deal(Card a, Card b, Card c, Card d){
		// Move a, b, c, and d onto the columns.
		// Argument names subject to change
	}
	
	public void move(int col1, int col2){
		// Try to move the top card from col1 to col2
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