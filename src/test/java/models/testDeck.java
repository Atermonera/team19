package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testDeck {
    @Test
    public void testStd(){
        Stack deckStd = new DeckStd();
        assertEquals(52, deckStd.getSize());

    }

    @Test
    public void testEs(){
        Stack deckEs = new DeckEs();
        assertEquals(50, deckEs.getSize());

    }

}