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
		PlayerHand dealer2 = new PlayerHand( new  Card("H10"), new Card("HA"));
		
		cinput.BlackJack(player);
		cinput.BlackJack(dealer2);
		
		cinput.WhoWins(player, dealer2);
		
		assertEquals(2, cinput.winner);
		
		//If player hand value > dealer hand value, player wins. 
		PlayerHand player2 = new PlayerHand( new  Card("H10"), new Card("H8"));
		PlayerHand dealer3 = new PlayerHand( new  Card("H10"), new Card("H7"));
		
		cinput.WhoWins(player2, dealer3);
		
		assertEquals(1, cinput.winner);
		
		//If !(player hand value > dealer hand value), dealer wins. 
		PlayerHand player3 = new PlayerHand( new  Card("H10"), new Card("H7"));
		PlayerHand dealer4 = new PlayerHand( new  Card("H10"), new Card("H8"));
		
		cinput.WhoWins(player3, dealer4);
		
		assertEquals(2, cinput.winner);
	}

}
