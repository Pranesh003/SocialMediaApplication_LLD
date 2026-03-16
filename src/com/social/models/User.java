package com.social.models;

import java.util.*;

public class User {
	private static int counter=1;

	private int userId;
	private String name;
	private String dob;
	private int age;
	private String location;
	private String occupation;
	
	private List<User> friends;
	private List<Post> posts;
	private List<Notification> notifications;
	
	private List<FriendRequest> sentRequests;
	private List<FriendRequest> receivedRequest;
	
	public User(String name, String dob, int age, String location, String occupation) {
		
		this.userId=counter++;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.location = location;
		this.occupation = occupation;
		
		friends= new ArrayList<>();
		posts= new ArrayList<>();
		notifications=new ArrayList<>();
		sentRequests=new ArrayList<>();
		receivedRequest=new ArrayList<>();
	}
	
	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	public String getDob() {
		return dob;
	}
	public int getAge() {
		return age;
	}
	public String getLocation() {
		return location;
	}
	public String getOccupation() {
		return occupation;
	}
	public List<User> getFriends() {
		return friends;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public List<FriendRequest> getReceivedRequest() {
		return receivedRequest;
	}
	public List<FriendRequest> getSentRequest(){
		return sentRequests;
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}
	
	public void addPost(Post post) {
		posts.add(post);
	}
	
	public void addNotification(Notification notification) {
		notifications.add(notification);
	}
	
	public void addFriendRequest(FriendRequest request) {
		receivedRequest.add(request);
	}
	
	public void addSentRequest(FriendRequest request) {
		sentRequests.add(request);
	}
	
}
