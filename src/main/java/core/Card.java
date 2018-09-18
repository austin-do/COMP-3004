package core;

public class Card {
	private String suite = "";
	private String number = "";
	private String command;
		
		public Card(String SuiteNumber) {
		
			String[] arrOfStr = SuiteNumber.split("");
			
			//Card should never be more than 3 characters;
			if (arrOfStr.length > 3) {
				System.out.println("Invalid input in file.");
				System.exit(0);
			}
			
			if (arrOfStr.length == 1) {
				this.setCommand(arrOfStr[0]);
			}
		
			else {
				//Set Suite
				this.setSuite(arrOfStr[0]);
				
				//Set Number
				try {
					this.setNumber(arrOfStr[1] + arrOfStr[2]);
				} catch (IndexOutOfBoundsException a) {
					this.setNumber(arrOfStr[1]);
				}
			}
			
			try {
				if (Integer.parseInt(this.number) > 10) {
					System.out.println("Invalid input in file");
					System.exit(0);
				}
			} catch (NumberFormatException a) {
				if (!(this.number).equals("J") &&
					!(this.number).equals("Q") &&
					!(this.number).equals("K") &&
					!(this.number).equals("A") &&
					!(this.number).equals("")) {
					
					System.out.println("Invalid input in file.");
					System.exit(0);
				}
			}

		}

		//GETTERS/SETTERS
		
		public String getNumber() {return number;}

		public void setNumber(String number) {this.number = number;}

		public String getSuite() {return suite;}

		public void setSuite(String suite) {this.suite = suite;}
		
		public String getSuiteNumber() {return suite + number;}

		public String getCommand() {return command;}

		public void setCommand(String command) {this.command = command;}
		
}
