package core;

public class Card {
	private String suite;
	private String number;
		
		public Card(String SuiteNumber) {
		
			String[] arrOfStr = SuiteNumber.split("");
			
			//Set Suite
			this.setSuite(arrOfStr[0]);
			
			//Set Number
			try {
				this.setNumber(arrOfStr[1] + arrOfStr[2]);
			} catch (IndexOutOfBoundsException a) {
				this.setNumber(arrOfStr[1]);
			}
			
		}

		//GETTERS/SETTERS
		
		public String getNumber() {return number;}

		public void setNumber(String number) {this.number = number;}

		public String getSuite() {return suite;}

		public void setSuite(String suite) {this.suite = suite;}
		
		public String getSuiteNumber() {return suite + number;}
		
}
