package com.social.models;

import java.time.LocalDateTime;


public class Comment {

	private User author;
	private String content;
	private LocalDateTime timestamp;
	
	public Comment(User author,String content) {
		this.author=author;
		this.content=content;
		this.timestamp=LocalDateTime.now();
	}
	
	public User getAuthor() {
		return author;
	}
	
	public String getContent() {
		return content;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String toString() {
		return author.getName()+":"+content;
	}
}
