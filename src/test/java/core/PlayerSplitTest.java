package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerSplitTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		PlayerHand hand1 = new PlayerHand( new Card("H6"), new Card("D3"));
		assertTrue(!cinput.splittable(hand1));
		
		PlayerHand hand2 = new PlayerHand( new Card("H6"), new Card("D6"));
		assertTrue(cinput.splittable(hand2));
	}

}
