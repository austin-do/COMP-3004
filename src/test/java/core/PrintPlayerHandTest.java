package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintPlayerHandTest {

	@Test
	public void test() {
		
		ConsoleInput cinput = new ConsoleInput();
		
		PlayerHand hand = new PlayerHand( new Card("HA"), new Card("HQ"));
		
		assertEquals(
				"HA HQ ", 
				cinput.printHand(hand));
	}

}
