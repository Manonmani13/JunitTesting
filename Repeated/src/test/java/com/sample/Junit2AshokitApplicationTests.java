package com.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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

	@ParameterizedTest
	@CsvFileSource(resources= "/data.csv",numLinesToSkip=1)
	public void testIsEvenOdd(String input, String expected)
	{
		System.out.println(input);
		EvenOddCheck pc=new EvenOddCheck();
		String actual=pc.evenOrOdd(Integer.parseInt(input));
	    assertEquals(expected,actual);
	}

	@Test
	public void testConveretToInt() {
		String str=null;
		assertThrows(IllegalArgumentException.class, ()->StringUtils.convertToInt(str));
	}

}
