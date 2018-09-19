package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class AceTest {

	@Test
	public void test() {
		//Ace can count as 1
		PlayerHand hand1 = new PlayerHand( new Card("H6"), new Card("H7"));
		hand1.addCard(new Card("HA"));
		
		assertEquals(14, hand1.Value());
		
		//Ace can count as 11
		PlayerHand hand2 = new PlayerHand( new Card("H2"), new Card("H3"));
		hand2.addCard(new Card("HA"));
		
		assertEquals(16, hand2.Value());
	}

}
