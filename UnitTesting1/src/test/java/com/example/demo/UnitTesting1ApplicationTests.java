package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitTesting1ApplicationTests {

	
	@Autowired
	private HomeController homeController;
	
	@Test
	void contextLoads() {
		assertThat(homeController).isNotNull();
	}

}
