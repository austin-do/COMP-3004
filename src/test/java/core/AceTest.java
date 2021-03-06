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
		
		//Ace can count as 11 and 1 in one hand
		PlayerHand hand3 = new PlayerHand( new Card("HA"), new Card("DA"));
		
		assertEquals(12, hand3.Value());
				
		//Ace can count as 11 and then 1 
		PlayerHand hand4 = new PlayerHand( new Card("HA"), new Card("D9"));
		hand4.addCard(new Card("DK"));
		
		assertEquals(20, hand4.Value());
	}

}
