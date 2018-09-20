package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerScoreTest {

	@Test
	public void test() {
		
		ConsoleInput cinput = new ConsoleInput();
		PlayerHand player = new PlayerHand(new Card("H10"), new Card("H8"));
		int val = cinput.printPlayerValue(player);
		assertEquals(18, val);
	}

}
