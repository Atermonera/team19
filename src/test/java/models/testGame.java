package models;

import org.junit.Test;

import java.util.Arrays;
import java.util.zip.CRC32;

import static org.junit.Assert.*;

public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game(0);
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game(0);
        assertEquals(52,g.deck.getSize());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game(0);
        Game g2 = new Game(0);
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.stack.toArray(),g2.deck.stack.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game(0);
        assertEquals(1,g.cols[0].getSize());
        assertEquals(1,g.cols[1].getSize());
        assertEquals(1,g.cols[2].getSize());
        assertEquals(1,g.cols[3].getSize());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game(0);
        g.customDeal(new Card(2, Suit.StdC), new Card(3, Suit.StdC), new Card(4, Suit.StdC), new Card(5, Suit.StdC));
        assertEquals("2StdC",g.cols[0].stack.get(0).toString());
        assertEquals("3StdC",g.cols[1].stack.get(0).toString());
        assertEquals("4StdC",g.cols[2].stack.get(0).toString());
        assertEquals("5StdC",g.cols[3].stack.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game(0);
        g.customDeal(new Card(2, Suit.StdC), new Card(3, Suit.StdC), new Card(4, Suit.StdC), new Card(5, Suit.StdC));
        g.remove(2);
        assertEquals(0,g.cols[2].getSize());

    }


    @Test
    public void testGameDealLowDeck(){
        Game g = new Game(1);
        while (g.deck.getSize() > 4){//deal cards until there are 4 or less, in the case of the Spanish deck, 2 left
            g.dealFour();
        }
       assertEquals(g.deck.getSize(), 2);
        Card card0 = g.deck.stack.get(0);
        Card card1 = g.deck.stack.get(1);
        g.dealFour();
        assertEquals(card0, g.cols[2].peek());
        assertEquals(card1, g.cols[1].peek());
    }
}
