package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintDealerHandTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		FileInput finput = new FileInput();
		
		PlayerHand hand = new PlayerHand( new Card("HA"), new Card("HQ"));
		
		assertEquals(
				"HA [] ", 
				cinput.printDealerHand(hand));
		assertEquals(
				"HA [] ", 
				finput.printDealerHand(hand));
	}

}
