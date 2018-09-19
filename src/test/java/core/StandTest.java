package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StandTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		PlayerHand hand = new PlayerHand( new Card("H10"), new Card("HJ"));
		assertTrue(cinput.stand(hand));
	}

}
