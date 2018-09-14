package core;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FileInputTest {

	@Test
	public void testFileInput() {
		FileInput finput = new FileInput();
		Cards[] cards = new Cards[];
		Assert.assertArrayEquals(
				cards, 
				finput(1));
	}
	
	@Test
	public void testEmptyFileInput() {
		FileInput finput = new FileInput();
		Cards[] cards = new Cards[];
		Assert.assertNull(
				"File was either empty or invalid.", 
				finput(2));
	}

}
