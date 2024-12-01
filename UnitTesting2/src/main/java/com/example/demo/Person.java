package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer personId;
	    private String personName;
	    private String personCity;
		public Person(Integer personId, String personName, String personCity) {
			super();
			this.personId = personId;
			this.personName = personName;
			this.personCity = personCity;
		}

}
