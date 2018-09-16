package core;

import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			String us = promptUser(sc);
			
			if(us.equals("c")){
				ConsoleInput game = new ConsoleInput();
				game.runGame();
				System.exit(0);
			}
			else if(us.equals("f")) {
				FileInput game = new FileInput();
				game.runGame();
				System.exit(0);
			}
			else {
				System.out.println("Invalid selection.");
			}
		}
	}
	
	public static String promptUser(Scanner sc) {
		System.out.println("Select console input (c) or file input (f).");
		
		if(sc.hasNextLine()) {
		String userSelection = sc.nextLine().toString().toLowerCase();
		return userSelection;
		}
		
		return "oops";
	}
}
