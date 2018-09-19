package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerMultipleHits {

	@Test
	public void test() {
		Deck deck = new Deck();
		deck.makeDeck();
		deck.shuffle();
		
		PlayerHand hand = new PlayerHand( new Card("H2"), new Card("H3"));
		
		int sizeBeforeHit = hand.getCards().size();
		
		//Hit Once
		hand.addCard(new Card("DQ"));
		
		assertEquals(
				sizeBeforeHit + 1 , 
				hand.getCards().size());
		
		//Hit Multiple
		hand.addCard(new Card("SQ"));
		
		assertEquals(
				sizeBeforeHit + 2 , 
				hand.getCards().size());
	
	}

}
