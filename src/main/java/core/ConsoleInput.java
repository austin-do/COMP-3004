package core;

import java.util.Iterator;
import java.util.Scanner;

public class ConsoleInput {
	Deck deck;
	PlayerHand player;
	PlayerHand dealer;
	int winner = 0;
	
	public boolean runGame() {

		PlayerHand player = new PlayerHand(1);
		PlayerHand dealer = new PlayerHand(2);
		
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
		
		System.out.println("------------------------------------------\n");
		PlayerTurn(player);
		System.out.println("------------------------------------------\n");
		DealerTurn(dealer);
		
		return true;
	}
	
	public String printHand(PlayerHand hand) {
		
		String ret = "";
		
		if(hand.getType() != 2)
			System.out.println("Player's Hand: " );
		if(hand.getType() == 2)
			System.out.println("Dealer's Hand: " );
		
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
		System.out.println("Player's Turn: \n");
		while(true) {
			Scanner sc = new Scanner(System.in);
			String us = PlayerMove(sc);
			
			if(us.equals("h")){
				System.out.println("Drawing Card...");
				player.drawCard(deck);
				if (player.Value() == 21) {
					BlackJack(player);
				}
				if(player.Value() > 21) {
					printHand(player);
					PlayerBust();
				}
				printHand(player);
				
			}
			else if(us.equals("s")) {
				stand(player);
				if (player.Value() == 21) {
					BlackJack(player);
				}
				break;
			}
			else {
				System.out.println("Invalid selection.");
			}
		}
	}

	public boolean DealerTurn(PlayerHand dealer) {
		System.out.println("Dealer's Turn: \n");
		boolean ret = false;
		//if dealers hand is <= 16, hit
		while (dealer.Value() <= 16) {
			System.out.println("Dealer Draws...");
			dealer.drawCard(deck);
			if (player.Value() == 21) {
				BlackJack(dealer);
			}
			if(dealer.Value() > 21) {
				printHand(dealer);
				DealerBust();
			}
			printDealerHand(dealer);
			
			//if Dealer has soft 17, hit
			if (dealer.Value() == 17) {
				for(Card card : dealer.getCards()) {
					if(card.getNumber().equals("A")) {
						System.out.println("Dealer Draws...");
						dealer.drawCard(deck);
						if (player.Value() == 21) {
							BlackJack(dealer);
						}
						if(dealer.Value() > 21) {
							printHand(dealer);
							DealerBust();
						}
						printDealerHand(dealer);
					}
				}
			}
		}
		
		System.out.println("Dealer Stands.\n");
		if (dealer.Value() == 21) {
			BlackJack(dealer);
		}
		printHand(dealer);
		
		ret = true;
		return ret;
	}

	public void DealerBust() {
		this.winner = 1;
		System.out.println("------------------------------------------");
		System.out.println("Dealer Bust! Player Wins.");
		System.exit(0);
	}
	
	public void PlayerBust() {
		this.winner = 2;
		System.out.println("------------------------------------------");
		System.out.println("Player Bust! Dealer Wins.");
		System.exit(0);
	}
	
	public void BlackJack(PlayerHand hand) {
		hand.hasBlackJack();
	}
	
	public void WhoWins(PlayerHand player, PlayerHand dealer) {
		if(player.blackjack && !dealer.blackjack) {
			this.winner = 1;
		}
		if(dealer.blackjack) {
			this.winner = 2;
		}
		if(player.Value() > dealer.Value()) {
			this.winner = 1;
		}
	}

	public int printPlayerValue(PlayerHand player) {
		int ret = player.Value();
		System.out.println("Value of Player's Hand: " + ret);
		return ret;
	}
	
	public int printDealerValue(PlayerHand dealer) {
		int ret = dealer.Value();
		System.out.println("Value of Dealer's Hand: " + ret);
		return ret;
	}
}

