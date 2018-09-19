package core;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PlayerTurnTest {

	@Test
	public void test() {
		
		ConsoleInput cinput = new ConsoleInput();
		PlayerHand hand = new PlayerHand( new Card("H10"), new Card("HJ"));
		
		ByteArrayOutputStream consoleStorage = new ByteArrayOutputStream();
		PrintStream newConsole = System.out;
		System.setOut(new PrintStream(consoleStorage));
		 
		PlayerTurn(hand);
		
		assertEquals(cinput.printHand(hand), consoleStorage.toString());
	}

}
