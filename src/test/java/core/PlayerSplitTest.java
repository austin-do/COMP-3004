package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerSplitTest {

	@Test
	public void test() {
		PlayerHand hand1 = new PlayerHand( new Card("H6"), new Card("D3"));
		assertTrue(!splittable(hand1));
		
		PlayerHand hand2 = new PlayerHand( new Card("H6"), new Card("D6"));
		assertTrue(splittable(hand2));
	}

}
