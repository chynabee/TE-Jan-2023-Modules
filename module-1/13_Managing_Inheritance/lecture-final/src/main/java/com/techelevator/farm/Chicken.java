package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	// 10. there is now an eat() method that must be implemented in its child objects
	@Override
	public String eat(){
		return "eating grasshoppers";
	}

}
