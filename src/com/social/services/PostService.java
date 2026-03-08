package com.social.services;
import com.social.models.*;
public class PostService {
	 public void createPost(User user, String content) {

	        Post post = new Post(content,user);

	        user.addPost(post);

	        // Notify friends
	        for(User friend : user.getFriends()){
	            friend.addNotification(
	                new Notification(user.getName() + " created a new post.")
	            );
	        }

	        System.out.println("Post created successfully!");
	    }
	
	public void likePost(Post post, User user) {
		post.like(user);
		post.getAuthor().addNotification(
				new Notification(user.getName()+" liked your post"));
	}
	
	public void commentpost(Post post, User user, String text) {
		post.addComment(user, text);
		post.getAuthor().addNotification(
				new Notification(user.getName()+" commented on your post"));
	}
	
	public void viewFeed(User user){

	    System.out.println("\n--- News Feed ---");

	    for(User friend : user.getFriends()){

	        for(Post post : friend.getPosts()){

	            System.out.println("\nPost ID: " + post.getPostId());
	            System.out.println("Author: " + post.getAuthor().getName());
	            System.out.println("Content: " + post.getContent());
	            System.out.println("Likes: " + post.getLikeCount());

	            System.out.println("Comments:");
	            for(Comment c : post.getComments()){
	                System.out.println(c);
	            }
	        }
	    }
	}
	
	public void sharePost(Post post, User sender, User receiver){

	    receiver.addNotification(
	            new Notification(
	                    sender.getName() +
	                    " shared a post with you: " +
	                    post.getContent()
	            )
	    );
	}
	public void viewNotifications(User user){

	    System.out.println("\n--- Notifications ---");

	    for(Notification n : user.getNotifications()){
	        System.out.println(n.getMessage());
	        n.markAsRead();
	    }

	    user.getNotifications().clear();
	}
	
	

}
