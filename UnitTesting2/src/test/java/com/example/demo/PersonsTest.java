package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)  // Use MockitoExtension for JUnit 5
public class PersonsTest {

    @Mock
    private PersonRepo personRepo;

    @InjectMocks
    private PersonService personService;

    @Test
    void getAllPersons() {
        // Arrange: Prepare sample person objects
        Person person = new Person(1, "Ahnis", "Gotham");
        Person person2 = new Person(2, "Saksham", "New York");

        // Mock the behavior of personRepo.findAll()
        given(personRepo.findAll()).willReturn(List.of(person, person2));

        // Act: Call the service method
        var personList = personService.getAllPerson();

        // Assert: Verify that the result is correct
        assertThat(personList).isNotNull();
        assertThat(personList.size()).isEqualTo(2);
        assertThat(personList).containsExactly(person, person2);  // Optionally assert that the list contains the exact persons
    }
}
