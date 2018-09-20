package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerBlackJackTest {

	@Test
	public void test() {
		
		ConsoleInput cinput = new ConsoleInput();
		
		PlayerHand player = new PlayerHand( new  Card("H10"), new Card("HA"));
	
		cinput.PlayerTurn(player);
		
		assertTrue(player.blackjack = true);

	}
 
}
