package core;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

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
					finput.readFile("/test1"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
