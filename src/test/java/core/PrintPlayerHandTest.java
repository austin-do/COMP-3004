package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintPlayerHandTest {

	@Test
	public void test() {
		
		ConsoleInput cinput = new ConsoleInput();
		Card card1 = new Card("HA");
		Card card2 = new Card("HQ");
		
		PlayerHand hand = new PlayerHand(card1, card2);
		
		assertEquals(
				"HA HQ", 
				cinput.printHand(hand));
	}

}
