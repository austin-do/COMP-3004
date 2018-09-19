package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FileInput {
	
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
	
	public PlayerHand checkInstructions(String instructionsString) {
		HashSet set = new HashSet();
		
		String[] instructions = instructionsString.split("\\s+");
		
		//Check for duplicate cards by putting cards into a set
		for (String Card : instructions) {
			if (set.add(Card) == false) {
				System.out.println("File contains invalid input.");
				System.exit(0);
			}
		}
		
		PlayerHand formatted = new PlayerHand();
		
		for (int i = 0; i < instructions.length; i++) {
			formatted.addCard(new Card(instructions[i]));
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
		
		//Check if there's less than 4 inputs given
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

}
