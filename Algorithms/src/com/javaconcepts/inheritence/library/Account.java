package com.javaconcepts.inheritence.library;

public abstract class Account {
	  private String id;
	  private String password;
	  private AccountStatus status;
	  private User user;

	  public abstract boolean resetPassword();
}
