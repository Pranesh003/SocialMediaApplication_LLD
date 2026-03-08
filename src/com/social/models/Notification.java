package com.social.models;

import java.time.LocalDateTime;

public class Notification {

	private String message;
	private boolean isRead;
	private LocalDateTime timestamp;
	
	public Notification(String message) {
		this.message=message;
		this.isRead=false;
		this.timestamp=LocalDateTime.now();
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isRead() {
		return isRead;
	}
	
	public void markAsRead() {
		this.isRead=true;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
