package com.social.services;

import java.util.List;

import com.social.models.*;

public class FriendService {
	
	public void sendFriendRequest(User sender, User receiver ) {
		FriendRequest request= new FriendRequest(sender, receiver);
		receiver.addFriendRequest(request);
		receiver.addNotification(new Notification(sender.getName()+" send you a friend request"));
	}
	
	public void acceptRequest(FriendRequest request) {
		request.accept();
		User sender=request.getSender();
		User receiver=request.getReceiver();
		
		sender.addFriend(receiver);
		receiver.addFriend(sender);
		
		sender.addNotification(new Notification(receiver.getName()+" accepeted your friend request"));
		
	}
	
	public void suggestFriends(User currentUser, List<User> allUsers) {

	    System.out.println("\n--- Friend Suggestions ---");

	    for (User user : allUsers) {

	        if (user == currentUser) continue;
	        if (currentUser.getFriends().contains(user)) continue;

	        int score = 0;

	        if (currentUser.getName().equalsIgnoreCase(user.getName()))
	            score++;

	        if (currentUser.getAge() == user.getAge())
	            score++;

	        if (currentUser.getLocation().equalsIgnoreCase(user.getLocation()))
	            score++;

	        if (currentUser.getDob().substring(5,7)
	                .equals(user.getDob().substring(5,7)))
	            score++;

	        if(score > 0){
	            System.out.println(user.getName() + " | Match Score: " + score);
	        }
	    }
	}
	
	public void showMutualFriends(User currentUser, List<User> users){

	    System.out.println("\n--- Mutual Friend Suggestions ---");

	    for(User user : users){

	        if(user == currentUser) continue;
	        if(currentUser.getFriends().contains(user)) continue;

	        int mutualCount = 0;

	        for(User friend : currentUser.getFriends()){
	            if(user.getFriends().contains(friend)){
	                mutualCount++;
	            }
	        }

	        if(mutualCount > 0){
	            System.out.println(user.getName() +
	                    " | Mutual Friends: " + mutualCount);
	        }
	    }
	}


}
