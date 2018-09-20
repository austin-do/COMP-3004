package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhoWinsTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		PlayerHand player = new PlayerHand( new  Card("H10"), new Card("HA"));
		PlayerHand dealer = new PlayerHand( new  Card("H10"), new Card("H8"));
		
		cinput.WhoWins(player, dealer);
		
		//if winner is a player
		assertEquals(1, winner.getType());
		assertEquals(1, cinput.winner);


		
	}

}
