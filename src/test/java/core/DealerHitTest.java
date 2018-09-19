package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerHitTest {

	@Test
	public void test() {
		
		//Test to see if dealer hits when hand size is < 16
		PlayerHand hand1 = new PlayerHand( new Card("H6"), new Card("H7"));
		int handSizeBefore = hand1.getCards().size();
		DealerTurn(hand1);
		int handSizeAfter = hand1.getCards().size();
		
		assertTrue(handSizeBefore < handSizeAfter);
				
		//Test to see if dealer hits when hand size is = 16
		PlayerHand hand2 = new PlayerHand( new Card("H6"), new Card("HJ"));
		handSizeBefore = hand2.getCards().size();
		DealerTurn(hand2);
		handSizeAfter = hand2.getCards().size();
		
		assertTrue(handSizeBefore < handSizeAfter);
		
		//Test to see if dealer does not hit when hand size is > 16
		PlayerHand hand = new PlayerHand( new Card("H10"), new Card("HJ"));
		handSizeBefore = hand.getCards().size();
		DealerTurn(hand);
		handSizeAfter = hand.getCards().size();
		
		assertTrue(handSizeBefore == handSizeAfter);
	}

}
