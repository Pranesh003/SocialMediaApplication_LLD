package com.social.models;

import java.time.LocalDateTime;
import java.util.*;

public class Post {

	private static int counter=1;
	private int postId;
	private String content;
	private User author;
	private LocalDateTime timestamp;
	
	private Set<User> likes;
	private List<Comment> comments;
	private int shareCount;
	
	public Post(String content, User author) {
		this.postId=counter++;
		this.content = content;
		this.author = author;
		this.timestamp=LocalDateTime.now();
		
		this.likes= new HashSet<>();
		this.comments=new ArrayList<>();
		this.shareCount=0;
		
	}
	
	public void like(User user) {
		likes.add(user);
	}
	
	public void addComment(User user, String text) {
		comments.add(new Comment(user, text));
	}

	public int getPostId() {
		return postId;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}
	
	public int getLikeCount() {
		return likes.size();
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void share() {
		shareCount++;
	}
	
	public int getShareCount() {
		return shareCount;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
}
