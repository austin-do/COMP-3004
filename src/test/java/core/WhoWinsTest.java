package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhoWinsTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		
		//If player has BlackJack but dealer doesn't
		PlayerHand player = new PlayerHand( new  Card("H10"), new Card("HA"));
		PlayerHand dealer = new PlayerHand( new  Card("H10"), new Card("H8"));
		
		cinput.BlackJack(player);
		cinput.WhoWins(player, dealer);
		
		//if winner is a player
		assertEquals(1, cinput.winner);
		
		//If dealer has BlackJack 
		PlayerHand dealer2 = new PlayerHand( new  Card("H10"), new Card("H8"));
		
		cinput.BlackJack(player);
		cinput.BlackJack(dealer);
		
		cinput.WhoWins(player, dealer2);
		
	}

}
