package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerScoreTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		PlayerHand dealer = new PlayerHand(new Card("H10"), new Card("H8"));
		int val = cinput.printDealerValue(dealer);
		assertEquals(18, val);
	}

}
