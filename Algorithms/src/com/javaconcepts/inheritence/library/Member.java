package com.javaconcepts.inheritence.library;

public class Member extends Account {

	@Override
	public boolean resetPassword() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean reserveBookItem(BookItem bookItem) {
		return false;
	}

	  private void incrementTotalBooksCheckedout();

}
