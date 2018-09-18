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
	
	public int Value() {
		int handValue = 0;
		int aces = 0;
		
		for(Card card : this.cards) {
			switch(card.getNumber()) {
			case "2": handValue += 2; break;
			case "3": handValue += 3; break;
			case "4": handValue += 4; break;
			case "5": handValue += 5; break;
			case "6": handValue += 6; break;
			case "7": handValue += 7; break;
			case "8": handValue += 8; break;
			case "9": handValue += 9; break;
			case "10": handValue += 10; break;
			case "J": handValue += 10; break;
			case "Q": handValue += 10; break;
			case "K": handValue += 10; break;
			case "A": aces += 1; break;
			
			}
		}
		return handValue;
	}
	
}
