package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testStack {
    @Test
    public void testPush(){
        Stack s = new Stack();
        s.push(new Card(5, Suit.StdS));
        assertEquals("5StdS",s.stack.get(0).toString());
        return;
    }

   @Test
   public void testPop(){
        Stack s = new Stack();
        Card toPush0 = new Card(5, Suit.StdH);
        Card toPush1 = new Card(2, Suit.StdH);
        s.push(toPush0);
        s.push(toPush1);
        assertEquals(toPush1, s.pop());
        assertEquals(toPush0, s.stack.get(0));
   }
}
