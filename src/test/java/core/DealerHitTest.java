package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerHitTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		cinput.runGame();
		
		//Test to see if dealer hits when hand size is < 16
		PlayerHand hand1 = new PlayerHand( new Card("H6"), new Card("H7"));
		int handSizeBefore = hand1.getCards().size();
		cinput.DealerTurn(hand1);
		int handSizeAfter = hand1.getCards().size();
		
		assertTrue(handSizeBefore < handSizeAfter);
				
		//Test to see if dealer hits when hand size is = 16
		PlayerHand hand2 = new PlayerHand( new Card("H6"), new Card("HJ"));
		handSizeBefore = hand2.getCards().size();
		cinput.DealerTurn(hand2);
		handSizeAfter = hand2.getCards().size();
		
		assertTrue(handSizeBefore < handSizeAfter);
		
		//Test to see if dealer does not hit when hand size is > 16
		PlayerHand hand3 = new PlayerHand( new Card("H10"), new Card("HJ"));
		handSizeBefore = hand3.getCards().size();
		cinput.DealerTurn(hand3);
		handSizeAfter = hand3.getCards().size();
		
		assertTrue(handSizeBefore == handSizeAfter);
		
		//Test to see if dealer hits with a soft 17
		PlayerHand hand4 = new PlayerHand( new Card("H6"), new Card("HA"));
		handSizeBefore = hand4.getCards().size();
		cinput.DealerTurn(hand4);
		handSizeAfter = hand4.getCards().size();
		
		assertTrue(handSizeBefore < handSizeAfter);
	}

}
