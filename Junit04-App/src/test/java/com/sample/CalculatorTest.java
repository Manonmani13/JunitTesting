package com.sample;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
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
