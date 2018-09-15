package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileInput {
	
	public String readFile(String fileName) throws FileNotFoundException {
		
		//Find file in current directory called fileInput
		String cwd = System.getProperty("user.dir");
		File file = new File(cwd + fileName);
		
		Scanner sc = new Scanner(file);
		
		//List<Card> cards = new ArrayList<Card>();
		StandardCharsets.UTF_8.name();
		String instructions = sc.useDelimiter("\\A").next();
		
		sc.close();
		
		return instructions;
	}
}
