package com.sample;

public class UserDaoImpl implements UserDao {

	@Override
	public String findNameById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("findNameById() called");
		return "John";
	}

	@Override
	public String findEmailById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("findEmailById() called");

		return "john.k@gmail.com";
	}

}
