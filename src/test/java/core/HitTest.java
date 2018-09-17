package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class HitTest {

	@Test
	public void test() {
		ConsoleInput cinput = new ConsoleInput();
		cinput.runGame();
		
		FileInput finput = new FileInput();
		
		PlayerHand hand = new PlayerHand( new Card("HA"), new Card("HQ"));
		int sizeBeforeHit = hand.getCards().size();
		
		assertEquals(
				sizeBeforeHit + 1 , 
				cinput.hit(hand).size() );
		assertEquals(
				"HA [] DQ", 
				finput.hit("DQ") );
	}

	}

}
