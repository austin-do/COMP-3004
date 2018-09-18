package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class HitTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		deck.makeDeck();
		deck.shuffle();
		
		PlayerHand hand1 = new PlayerHand( new Card("HA"), new Card("HQ"));
		PlayerHand hand2 = new PlayerHand( new Card("HA"), new Card("HQ"));
		
		int sizeBeforeHit = hand1.getCards().size();
		
		//Hit once (console)
		hand1.drawCard(deck);
		
		assertEquals(
				sizeBeforeHit + 1 , 
				hand1.getCards().size());
		
		//Hit multiple (console)
		hand1.drawCard(deck);
		
		assertEquals(
				sizeBeforeHit + 2 , 
				hand1.getCards().size());
		
		//Hit once (file)
		hand2.addCard(new Card("DQ"));
		
		assertEquals(
				sizeBeforeHit + 1, 
				hand2.getCards().size());
		
		//Hit Multiple (file)
		hand2.addCard(new Card("SQ"));
		
		assertEquals(
				sizeBeforeHit + 2, 
				hand2.getCards().size());
	}

}

