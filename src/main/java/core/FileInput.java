package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FileInput {
	
	int winner = 0;
	
	public String readFile(String fileName) throws FileNotFoundException {
		
		//Find file in current directory called fileInput
		String cwd = System.getProperty("user.dir");
		File file = new File(cwd + "\\" + fileName);
		
		Scanner sc = new Scanner(file);
		
		//List<Card> cards = new ArrayList<Card>();
		StandardCharsets.UTF_8.name();
		String instructions = sc.useDelimiter("\\A").next();
		
		sc.close();
		
		return instructions;
	}
	
	public void runGame() {
		
		Deck deck = new Deck();
		String instructionsString = "";
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String us = promptUser(sc);
			
			System.out.println("Reading file...");
			
			try {
				instructionsString = readFile(us);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Invalid File Name.\n");
			}
		}
		
		PlayerHand formatted = checkInstructions(instructionsString);
		
		processInstructions(formatted);

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
	
	public PlayerHand checkInstructions(String instructionsString) {
		HashSet set = new HashSet();
		
		String[] instructions = instructionsString.split("\\s+");
		
		PlayerHand formatted = new PlayerHand();
		
		for (int i = 0; i < instructions.length; i++) {
			formatted.addCard(new Card(instructions[i]));
		}
		
		for(Card card : formatted.getCards()) {
			if(card.getCommand() == null) {
				System.out.println(card.getSuiteNumber());
				if (set.add(card) == false) {
					System.out.println("File contains invalid input.");
					System.exit(0);
				}
			}
		}
		
		return formatted;
	
	}
	
	public void processInstructions(PlayerHand formatted) {
		PlayerHand player = new PlayerHand();
		PlayerHand dealer = new PlayerHand();
		
		//Check to see if any of the first four inputs are commands
		for(int i = 0; i < 4; i++) {
			if (formatted.getCards().get(i).getCommand() != null) {
				System.out.println("Invalid file input.");
				System.exit(0);
			}
		}
		
		//Check if there's less than 4 inputs given / Deal initial hands
		try {
			player.addCard(formatted.getCards().get(0));
			player.addCard(formatted.getCards().get(1));
			dealer.addCard(formatted.getCards().get(2));
			dealer.addCard(formatted.getCards().get(3));
		}catch(NullPointerException n){
			System.out.println("Invalid file input.");
			System.exit(0);
		}
		
		printHand(player);
		printDealerHand(dealer);
		
		int start = PlayerTurn(player, formatted);
		DealerTurn(dealer, formatted, start);
	} 
	
	public static String promptUser(Scanner sc) {
		System.out.println("Enter filename: ");
		
		if(sc.hasNextLine()) {
		String fn = sc.nextLine().toString().toLowerCase();
		return fn;
		}
		
		return "oops";
	}
	
	public boolean stand(PlayerHand player) {
		
		System.out.println("-----------------------------------------------");
		printHand(player);
		System.out.println("-----------------------------------------------");
		return true;
	}
	
	public int PlayerTurn(PlayerHand player, PlayerHand formatted) {
		int i = 4;
		try {
		while(formatted.getCards().get(i).getCommand() != null) {
			if(formatted.getCards().get(i).getCommand().equals("H")) {
				System.out.println("Player Hits");
				//if hit command found, add next input in file
				player.addCard(formatted.getCards().get(i + 1));
				//increment i by 2 to skip to next command
				printHand(player);
				
				if(player.Value() > 21) {
					printHand(player);
					PlayerBust();	
				}
				
				if(player.Value() == 21) {
					BlackJack(player);
				}
				
				i = i + 2;
			}
			if(formatted.getCards().get(i).getCommand().equals("S")) {
				System.out.println("Player Stands");
				System.out.println("---------------------------------------\n");
				if(player.Value() == 21) {
					BlackJack(player);
				}
				//return index so dealer turn knows where to start
				return (i +1);
			}
			if(!formatted.getCards().get(i).getCommand().equals("H") && !formatted.getCards().get(i).getCommand().equals("S")) {
				System.out.println("Invalid Commands...");
				System.exit(0);
			}
		}
		}catch (NullPointerException e) {
			System.out.println("Invalid file input.");
			System.exit(0);
		}
		
		return i;
	}
	
	public void DealerTurn(PlayerHand dealer, PlayerHand formatted, int start) {
		try {
			while(formatted.getCards().get(start) != null) {
				if (dealer.Value() <= 16) {
					System.out.println("Dealer Hits...");
					dealer.addCard(formatted.getCards().get(start));
					if (dealer.Value() == 21) {
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
								start++;
								System.out.println("Dealer Hits...");
								dealer.addCard(formatted.getCards().get(start));
								if (dealer.Value() == 21) {
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
					
					start ++;
				}
			}
			
		}catch (NullPointerException | IndexOutOfBoundsException i) {
			
		}
	}
	
	public void PlayerBust() {
		System.out.println("------------------------------------------");
		System.out.println("Player Bust! Dealer Wins.");
		System.exit(0);
	}
	
	public void DealerBust() {
		System.out.println("------------------------------------------");
		System.out.println("Dealer Bust! Player Wins.");
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
	}
}
