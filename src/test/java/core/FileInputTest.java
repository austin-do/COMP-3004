package core;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class FileInputTest extends TestCase{

	@Test
	public void testFileInput() {
		FileInput finput = new FileInput();
		
		Card[] cards = {new Card("SK"), new Card("HA"), new Card("HQ"), new Card("CA")};
		
		Assert.assertArrayEquals(
				cards, 
				finput.readFile(test1));
		
	}

}
