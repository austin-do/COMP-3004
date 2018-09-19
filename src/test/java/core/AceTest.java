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
	}

}
