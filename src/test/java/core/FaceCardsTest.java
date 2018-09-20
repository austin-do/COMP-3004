package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaceCardsTest {

	@Test
	public void test() {
		PlayerHand hand1 = new PlayerHand( new Card("HJ"), new Card("H10"));
		
		assertEquals(20, hand1.Value());
		
		PlayerHand hand2 = new PlayerHand( new Card("HQ"), new Card("H10"));
		
		assertEquals(20, hand2.Value());
		
		PlayerHand hand3 = new PlayerHand( new Card("HK"), new Card("H10"));
		
		assertEquals(20, hand3.Value());
	}

}
