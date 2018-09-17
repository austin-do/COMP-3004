package core;

import java.util.Iterator;

public class ConsoleInput {
	Deck deck;
	PlayerHand player;
	PlayerHand dealer;
	
	public boolean runGame() {
		Deck deck;
		PlayerHand player = new PlayerHand();
		PlayerHand dealer = new PlayerHand();
		
		deck = new Deck();
		deck.makeDeck();
		deck.shuffle();
		
		System.out.println("Dealing cards...");
		
		player.drawCard(deck);
		player.drawCard(deck);
		
		printHand(player);
		
		dealer.drawCard(deck);
		dealer.drawCard(deck);
		
		printDealerHand(dealer);
		
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
	
	public String printDealerHand(PlayerHand hand) {
		
		String ret = "";
		
		System.out.println("Dealer's Hand: " );
		
		ret += hand.getCards().get(0).getSuiteNumber() + " [] ";
		
		Iterator<Card> PH = hand.getCards().listIterator(2);
		while(PH.hasNext()) {
			ret += PH.next().getSuiteNumber() + " ";
		}
		
		System.out.println(ret);
		return ret;
	}

}

