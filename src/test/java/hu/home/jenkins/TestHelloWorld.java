package hu.home.jenkins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHelloWorld {

	private HelloWorld helloWorld;
	
	@Before
	public void setUp() throws Exception {
		helloWorld = new HelloWorld();
		helloWorld.setMessage("Jenkins");
	}

	@Test
	public void testMessage() {
		assertEquals("Should be the same", "Hello Jenkins", helloWorld.getMessage());
	}

}
