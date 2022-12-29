package hu.home.jenkins;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
	
	@Test
	public void testMockMessage() {
		HelloWorld mockHelloWorld = Mockito.mock(HelloWorld.class);
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("Jonathan");
		
		String actual = helloWorld.getMessage();

		when(mockHelloWorld.getMessage()).thenReturn("Hello Jonathan");
		
		String expected = mockHelloWorld.getMessage();
		
		assertEquals(expected, actual);
		
		verify(mockHelloWorld).getMessage();
		
	}

}
