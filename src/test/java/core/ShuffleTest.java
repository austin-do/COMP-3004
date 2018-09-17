package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShuffleTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		deck.makeDeck();
		
		Card Initial = deck.getCards().get(0);
		
		deck.shuffle();
		Card Shuffled = deck.getCards().get(0);
		
		assertNotSame(Initial, Shuffled);
	}

}
