package com.social.models;

import java.time.LocalDateTime;

public class FriendRequest {
	
	private static int counter=1;

	private User sender;
	private User receiver;
	private RequestStatus status;
	private int requestId;
	private LocalDateTime timestamp;
	
	public FriendRequest(User sender, User receiver) {
		
		this.requestId=counter++;
		this.sender = sender;
		this.receiver = receiver;
		this.status=RequestStatus.PENDING;
		this.timestamp=LocalDateTime.now();
	}
	public User getSender() {
		return sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public int getRequestId() {
		return requestId;
	}
	public RequestStatus getStatus() {
		return status;
	}
	
	public void accept() {
		status=RequestStatus.ACCEPTED;
	}
	
	public void reject() {
		status=RequestStatus.REJECTED;
	}
	
	
}
