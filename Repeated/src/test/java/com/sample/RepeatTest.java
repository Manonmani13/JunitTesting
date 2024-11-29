package com.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

//@SpringBootTest
class RepeatTest {

	@Test
	@RepeatedTest(2)
	public void repeatedTestMethod() {
		System.out.println("I am executing this test multiple times.");
	}
	@Test
	@RepeatedTest(value=2,	name="{displayName} - repetition - {currentRepetition}/{totalRepetition}")
	public void repeatedTestMethod1() {
		System.out.println("I am executing this test multiple times.");
	}

}
