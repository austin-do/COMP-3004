package core;

import java.util.ArrayList;

public class PlayerHand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public PlayerHand(Card c1, Card c2) {
		this.cards.add(c1);
		this.cards.add(c2);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
}
