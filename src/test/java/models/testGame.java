package models;

import org.junit.Test;

import java.util.Arrays;

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
        assertEquals(52,g.deck.cards.size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game(0);
        Game g2 = new Game(0);
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game(0);
        assertEquals(1,g.columns.get(0).cards.size());
        assertEquals(1,g.columns.get(1).cards.size());
        assertEquals(1,g.columns.get(2).cards.size());
        assertEquals(1,g.columns.get(3).cards.size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game(0);
        g.customDeal(new Card(2, StdC), new Card(3, StdC), new Card(4, StdC), new Card(5, StdC));
        assertEquals("2Clubs",g.columns.get(0).cards.get(0).toString());
        assertEquals("3Clubs",g.columns.get(1).cards.get(0).toString());
        assertEquals("4Clubs",g.columns.get(2).cards.get(0).toString());
        assertEquals("5Clubs",g.columns.get(3).cards.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game(0);
        g.customDeal(new Card(2, StdC), new Card(3, StdC), new Card(4, StdC), new Card(5, StdC));
        g.remove(2);
        assertEquals(0,g.columns.get(2).cards.size());
    }



}
