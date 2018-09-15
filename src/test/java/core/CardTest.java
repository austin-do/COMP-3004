package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testSuite() {
		Card card = new Card("S10");
		assertEquals("S", card.getSuite());
	}
	
	@Test
	public void testNumber() {
		Card card = new Card("SA");
		assertEquals("A", card.getNumber());
	}

}
