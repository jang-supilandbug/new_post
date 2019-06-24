package com.example.post.exception;

public class PostException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PostException() {
		super("PostDAOException Occurred.");
	}
	
	public PostException(String msg) {
		super(msg);
	}
}
