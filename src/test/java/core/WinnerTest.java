package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinnerTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		cinput.DealerBust();
		
		assertTrue(cinput.getWinner() == 1); 
		
		cinput.PlayerBust();
		
		assertTrue(cinput.getWinner() == 2);
		
	}

}
