package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StandTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		assertTrue(cinput.stand());
	}

}
