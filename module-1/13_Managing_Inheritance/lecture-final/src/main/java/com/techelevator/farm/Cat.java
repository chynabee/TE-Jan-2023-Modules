package com.techelevator.farm;

public class Cat extends FarmAnimal{
    public Cat(String name, String sound) {
        super(name, sound);
    }
    // 10. there is now an eat() method that must be implemented in its child objects
    @Override
    public String eat(){
        return "eating meow mix";
    }
//    // 6. this is an example of a breaking change. Cat will meow even if it is asleep because of this overriden method
//    @Override
//    public String getSound(){
//        return "Meow meow";
//    }
}
