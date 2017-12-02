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

}
