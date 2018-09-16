package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConsoleInputTest {

	@Test
	public void testConsoleInput() {
		ConsoleInput cinput = new ConsoleInput();
		assertTrue(cinput.runGame());
	}

}
