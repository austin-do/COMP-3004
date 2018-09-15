package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.PlayerHand;

public class FileInput {
	
	public String readFile(String fileName) throws FileNotFoundException {
		
		//Find file in current directory called fileInput
		String cwd = System.getProperty("user.dir");
		File file = new File(cwd + fileName);
		Scanner sc = new Scanner(file);
		
		List<Card> cards = new ArrayList<Card>();
		
		while(sc.hasNextLine()) {
				Card card = new Card(sc.toString());
				cards.add(card);
		}
		
		//Card should never be more than 3 characters
		if (arrOfStr.length > 3) {
			System.out.println("Invalid input in file.");
			System.exit(0);
		}
		
		//Card should never have a number greater than 10
		//Or a value that is not J, Q, K, A
		try {
		if (Integer.parseInt(this.number) > 10)
			System.out.println("Invalid input in file.");
			System.exit(0);
		}catch (NumberFormatException a) {
			//Card should not have a suite value that is not S,H,D,C
			if(this.number != "J" && this.number != "Q" && this.number != "K" && this.number != "A")
				System.out.println("Invalid input in file.");
				System.exit(0);
		}
		sc.close();
	}
}
