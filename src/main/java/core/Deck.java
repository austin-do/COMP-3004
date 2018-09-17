package core;

import java.util.ArrayList;
import java.util.Random;

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
	
	public void shuffle() {
		ArrayList<Card> tmp = new ArrayList<Card>();
		Random random = new Random();
		int randIndex = 0;
		int size = this.cards.size();

		try {
			for(int i = 0; i < size; i++) {
				randIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
				tmp.add(cards.get(randIndex));
				this.cards.remove(randIndex);
			}
		}catch (IllegalArgumentException e) {
			System.out.println("Deck has not been created.");
		}
		
		this.cards = tmp;
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public ArrayList<Card> getCards() {return this.cards;}
	
}
