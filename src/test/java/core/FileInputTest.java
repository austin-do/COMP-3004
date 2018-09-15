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
		PlayerHand[] guestCards = new PlayerHand["value"];
		PlayerHand[] dealerCards = new PlayerHand["value"];
		
		Assert.assertArrayEquals(
				guestCards, 
				readFile(1));
		
		Assert.assertArrayEquals(
				dealerCards, 
				readFile(1));
	}

}
