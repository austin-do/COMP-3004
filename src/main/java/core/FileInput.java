package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
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
		PlayerHand player = new PlayerHand();
		PlayerHand dealer = new PlayerHand();
		String instructions = "";
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String us = promptUser(sc);
			
			System.out.println("Reading file...");
			
			try {
				instructions = readFile(us);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Invalid File Name.\n");
			}
		}
		
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
	
	public static String promptUser(Scanner sc) {
		System.out.println("Enter filename: ");
		
		if(sc.hasNextLine()) {
		String fn = sc.nextLine().toString().toLowerCase();
		return fn;
		}
		
		return "oops";
	}
}
