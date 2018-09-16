package core;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class ConsoleInputTest {

	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		String cinput = sc.nextLine();
		sc.close();
		
		assertEquals("c", cinput);
	}

}
