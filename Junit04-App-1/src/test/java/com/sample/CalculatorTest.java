package com.sample;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private static Calculator cal=null;
	
	@BeforeClass
	public static void init()
	{
		try {
			cal=new Calculator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void afterAll()
	{
		cal=null;
	}
	
	@Test
	public void testAdd() {
		Calculator c=new Calculator();
		Integer actual=c.add(10,30);
		Integer expected =40;
		assertEquals(expected,actual);
	}
	@Test
	public void testMultiply() {
		Calculator c=new Calculator();
		Integer actual=c.multiply(10,30);
		Integer expected =300;
		assertEquals(expected,actual);
	}

}
