package core;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;
	private String[] Suit = {"C", "H", "D", "S"};
	private String[] Number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void makeDeck() {
		for (String cardSuit : Suit) {
			for (String number : Number) {
				this.cards.add(new Card(cardSuit + number));
			}
		}
	}
	
	public ArrayList<Card> getCards() {return this.cards;}
	
}
