package core;

import java.util.ArrayList;

public class PlayerHand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int type = 0;
	
	public PlayerHand() {}
	
	public PlayerHand(int t) {
		this.setType(t);
	}
	
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
		
		//converts string values into ints so arithmetic can be used
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
		
		for(int i = 0; i <aces; i++) {
			if(handValue > 10) {
				handValue += 1;
			}
			else {
				handValue += 11;
			}
		}
		return handValue;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
