package core;

import java.util.ArrayList;

public class PlayerHand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public PlayerHand() {}
	
	public PlayerHand(Card c1, Card c2) {
		this.cards.add(c1);
		this.cards.add(c2);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void drawCard(Deck deck) {
		this.cards.add(deck.getCards().get(0));
		deck.removeCard(0);
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
}
