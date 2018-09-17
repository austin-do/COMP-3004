package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		
		assertEquals(0, deck.getCards().size());
		
		deck.makeDeck();
		
		assertEquals(52, deck.getCards().size());
		
	}

}
