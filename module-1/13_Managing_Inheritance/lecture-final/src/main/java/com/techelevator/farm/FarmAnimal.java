package com.techelevator.farm;

// 8. make this class abstract so that it cannot be instantiated
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;

	// 1. creating a new asleep property that will be used to make animals snore in getSound() method
	private boolean isAsleep;
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}
	// 2. if animal is asleep then they should return a snore string instead of their regular sound
	// 7. Added final to this method signature to correct problem with cat
	public final String getSound( ) {
		if(isAsleep){
			return "ZZZZzzz...";
		}
		return sound;
	}

	public void sleep(Boolean isAsleep){
		this.isAsleep = isAsleep;
	}

	// 9. just the signature of an abstract method eat() that every child class will have to override and implement
	public abstract String eat();


}
