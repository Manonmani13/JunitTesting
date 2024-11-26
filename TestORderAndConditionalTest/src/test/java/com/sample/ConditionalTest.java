package com.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {
	
	
	@Test
	@EnabledOnOs(OS.MAC)
	public void conditionOnOs() {
		System.out.println("Execute this test only in MAC machine");
	}
	@Test
	@EnabledOnJre(JRE.JAVA_11)
	public void conditionOnJre() {
		System.out.println("Execute this test only for Java 11");
	}
	@Test
	@EnabledForJreRange(min=JRE.JAVA_8,max=JRE.JAVA_11)
	public void conditionOnJreRange() {
		System.out.println("Execute this test only for Java 8-11");
	}
}
