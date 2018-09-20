package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerBlackJackTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		
		PlayerHand dealer = new PlayerHand( new  Card("H10"), new Card("HA"));
	
		cinput.DealerTurn(dealer);
		
		assertTrue(dealer.blackjack = true);
	}

}
