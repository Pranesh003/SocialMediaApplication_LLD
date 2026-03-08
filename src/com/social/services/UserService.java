package com.social.services;

import java.util.*;
import com.social.models.*;
public class UserService {

	private List<User> users=new ArrayList<>();
	
	public User signup(String name, String dob, int age, String location, String occupation) {
		User user=new User(name, dob, age, location, occupation);
		users.add(user);
		return user;
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User findUserByName(String name) {
		for(User user:users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	public void viewFriends(User user){

	    System.out.println("\n--- Friend List ---");

	    for(User friend : user.getFriends()){

	        System.out.println(
	                friend.getName() + " | " +
	                friend.getAge() + " | " +
	                friend.getLocation() + " | " +
	                friend.getOccupation()
	        );
	    }
	}
}
