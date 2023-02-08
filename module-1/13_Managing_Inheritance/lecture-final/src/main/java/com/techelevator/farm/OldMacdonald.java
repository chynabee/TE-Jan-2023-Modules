package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		// 3. Created new animal that I would be able to later modify their sleep properties
		Cow cow = new Cow();
		Pig pig = new Pig();
		Cat cat = new Cat("Catname", "meow");

		// 4. using the sleep method to set all of these animals to asleep so that they will snore in the song
		cow.sleep(true);
		pig.sleep(true);
		cat.sleep(true);

		// 5. Added the above animals to this list so that they will be used in the song
		Singable[] singables =
				new Singable[] {cow, cat, pig, new Tractor()};
//
//		for (Singable singable : singables) {
//			String name = singable.getName();
//			String sound = singable.getSound();
//			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
//			System.out.println("And on his farm he had a " + name
//					+ ", ee, ay, ee, ay, oh!");
//			System.out.println("With a " + sound + " " + sound + " here");
//			System.out.println("And a " + sound + " " + sound + " there");
//			System.out.println("Here a " + sound + " there a " + sound
//					+ " everywhere a " + sound + " " + sound);
//			System.out.println();
//		}
		// 11. iterating through the singables to print what they are eating and using 'instanceof FarmAnimal' to deny the tractor causing an error
		for (Singable singable : singables) {
			if(singable instanceof FarmAnimal){
				System.out.println("I am " + singable.getName() + " and I am " + ((FarmAnimal) singable).eat());
			}


		}
		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}
