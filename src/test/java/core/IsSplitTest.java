package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsSplitTest {

	@Test
	public void test() {
		PlayerHand player = new PlayerHand();
		player.isSplit = true;
		assertTrue(player.isSplit);
	}

}
