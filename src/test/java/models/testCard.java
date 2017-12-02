package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.StdC);
        assertEquals(Suit.StdC,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.StdC);
        assertEquals("5StdC",c.toString());
    }

    @Test
    public void testMoveCard(){
        Game g = new Game(0);
        for(int i = 0; i < 4; i++)
            g.cols[i] = new Stack();

        g.customDeal(new Card(14, Suit.StdC), new Card(3, Suit.StdC), new Card(4, Suit.StdC), new Card(2, Suit.StdC));
        g.remove(2);
        assertEquals(0,g.cols[2].getSize());
        g.move(0,2);
        assertEquals(1,g.cols[2].getSize());
        assertEquals(0,g.cols[0].getSize());
    }


}
