package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Students must implement dealFour(), remove(), move(), and columnHasCards() methods
 *
 * The customDeal() method is not present in the Assignment1_Student version since tests (and the test dir) are removed
 * to prevent confusion regarding testing and the use of unit tests; testing is covered more thoroughly in CS362.
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

		public java.util.List<Column> Columns = new ArrayList<>();

    public boolean removeCard;


    public Game(){
				Columns.add(new Column());
				Columns.add(new Column());
				Columns.add(new Column());
				Columns.add(new Column());
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.C));
            deck.add(new Card(i,Suit.H));
            deck.add(new Card(i,Suit.D));
            deck.add(new Card(i,Suit.S));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++){
            Columns.get(i).pushCard(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }

    public void remove(int columnNumber) {
        this.removeCard = false;
        if(this.Columns.get(columnNumber).hasCards()) {
            Card c = this.Columns.get(columnNumber).getTop();
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (this.Columns.get(i).hasCards()) {
                        Card compare = this.Columns.get(i).getTop();
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
								this.Columns.get(columnNumber).popCard();
                this.removeCard = true;
            }
        }
    }

    public void move(int columnFrom, int columnTo) {
        Card cardToMove = this.Columns.get(columnFrom).getTop();
				if (cardToMove.getValue() == 14 && this.Columns.get(columnTo).hasCards() == false){
					this.Columns.get(columnFrom).popCard();
					this.Columns.get(columnTo).pushCard(cardToMove);
				}
    }
}
