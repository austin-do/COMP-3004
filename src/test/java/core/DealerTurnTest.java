package core;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class DealerTurnTest {

	@Test
	public void test() {

		ConsoleInput cinput = new ConsoleInput();
		PlayerHand hand = new PlayerHand( new Card("H10"), new Card("H9"));
		
		assertTrue(cinput.DealerTurn(hand));
	}

}
