package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerBustTest {

	@Test
	public void test() {
		PlayerHand hand = new PlayerHand( new Card("H10"), new Card("HJ"));
		
		hand.addCard(new Card("HQ"));
		
		assertTrue(hand.Value() > 21);
		
		PlayerHand hand2 = new PlayerHand( new Card("H10"), new Card("HJ"));
		
		assertTrue(hand2.Value() < 21);
	}

}
