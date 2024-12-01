package com.example.demo;

import java.util.List;

public class PersonService {
	private final PersonRepo repo;
	   public PersonService(PersonRepo repo)
	    {
	        // this keyword refers to current instance
	        this.repo = repo;
	    }

	    public List<Person> getAllPerson()
	    {   
	        return repo.findAll();
	    }
}
