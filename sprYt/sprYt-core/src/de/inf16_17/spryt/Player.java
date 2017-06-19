package de.inf16_17.spryt;

public class Player {

	private String name;
	private Gender gender;
	private Sex sex;
	private boolean inRelationship;
	
	public Player(String name, Gender gender, Sex sex, boolean inRelationship) {
		
		this.name = name;
		this.gender = gender;
		this.sex = sex;
		this.inRelationship = inRelationship;
	}
	
	// Getter
	public String getName() {
		return this.name;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public Sex getSex() {
		return this.sex;
	}
	
	public boolean isInRelationship() {
		return this.inRelationship;
	}
}
