package com.sample;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//@SpringBootTest
class Junit2AshokitApplicationTests {

	
	
	@ParameterizedTest
	@ValueSource(strings= {"racecar","radar","madam","liril"})
	public void testIsPalindrome(String str)
	{
		PalindromeCheck pc=new PalindromeCheck();
		boolean actual=pc.isPalindrome(str);
	    assertTrue(actual);
	}

	

}
