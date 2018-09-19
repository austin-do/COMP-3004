package core;

import java.util.Iterator;
import java.util.Scanner;

public class ConsoleInput {
	Deck deck;
	PlayerHand player;
	PlayerHand dealer;
	
	public boolean runGame() {

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
		
		PlayerTurn(player);
		
		DealerTurn(dealer);
		
		printHand(player);
		printHand(dealer);
		
		return true;
	}
	
	public String printHand(PlayerHand hand) {
		
		String ret = "";
		
		System.out.println("Player's Hand: " );
		
		Iterator<Card> PH = hand.getCards().iterator();
		while(PH.hasNext()) {
			ret += PH.next().getSuiteNumber() + " ";
		}
		
		System.out.println(ret + "\n");
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
		
		System.out.println(ret + "\n");
		return ret;
	}

	public String PlayerMove(Scanner sc) {
		System.out.println("Would you like to (H)it or (S)tand? ");
		
		if(sc.hasNextLine()) {
		String userSelection = sc.nextLine().toString().toLowerCase();
		return userSelection;
		}
		
		return "oops";	
	}
	
	public boolean stand(PlayerHand player) {
		printHand(player);
		return true;
	}
	
	public void PlayerTurn(PlayerHand player) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			String us = PlayerMove(sc);
			
			if(us.equals("h")){
				player.drawCard(deck);
				if(player.Value() > 21) {
					printHand(player);
					System.out.println("---------------------------------------");
					System.out.println("Player Bust! Dealer wins.");
					System.exit(0);;
				}
				printHand(player);
				
			}
			else if(us.equals("s")) {
				stand(player);
				break;
			}
			else {
				System.out.println("Invalid selection.");
			}
		}
	}

	public void DealerTurn(PlayerHand dealer) {
		//if dealers hand is <= 16, hit
		while (dealer.Value() <= 16) {
			System.out.println("Dealer Draws...");
			dealer.drawCard(deck);
			printDealerHand(dealer);
			
			//if Dealer has soft 17, hit
			if (dealer.Value() == 17) {
				for(Card card : dealer.getCards()) {
					if(card.getNumber().equals("A")) {
						System.out.println("Dealer Draws...");
						dealer.drawCard(deck);
						printDealerHand(dealer);
					}
				}
			}
		}
	}

}

