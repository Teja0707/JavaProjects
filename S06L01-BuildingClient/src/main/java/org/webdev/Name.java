package org.webdev;

public class Name {
	
	private String firstName;
	private String lastName;
	
	
	public Name() {
		
	}
	
	

	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

}
