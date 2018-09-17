package core;

import java.util.Iterator;

public class ConsoleInput {
	public boolean runGame() {
		return true;
	}
	
	public String printHand(PlayerHand hand) {
		
		String ret = "";
		
		System.out.println("Player's Hand: " );
		
		Iterator<Card> PH = hand.getCards().iterator();
		while(PH.hasNext()) {
			ret += PH.next().getSuiteNumber() + " ";
		}
		
		System.out.println(ret);
		return ret;
	} 

}

