package core;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class FileInputTest extends TestCase{

	@Test
	public void testFileInput() {
		FileInput finput = new FileInput();
		
		String fileinput = "SK HA HQ CA";
		
		try {
			Assert.assertEquals(
					fileinput, 
					finput.readFile("/test1.txt"));
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
	}

}
