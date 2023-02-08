# Example 1: Avengers & Polymorphism

Thinking through what inheritance and polymorphism

## Learning objectives

After completing this exercise, you'll be able to:

- Explain the concept of polymorphism and how it's useful
- Demonstrate an understanding of where inheritance can assist in writing polymorphic code
- State the purpose of interfaces and how they're used
- Use polymorphism through inheritance using IS-A relationships
- Use polymorphism through interfaces using CAN-DO relationships

## Avengers, Assemble!

Two core principles of Object Oriented Programming (OOP) are inheritance and polymorphism. Inheritance let's us write a class with some general functionality that more specific classes can use. This let's us write code once, instead of having to copy and paste it everywhere. 

As an example of a class that has some general functionality, let's think about the Avengers. We know certain things must be true about an Avenger, even if we don't know the specific superhero we are talking about. For instance, every Avenger has a name and some sort of capability. We can make an Avenger class that has these two properties, that way we don't have to repeat it for each individual superhero.

Let's visit that class first
### The Avenger Class

If you open up Avenger.java under com.techelevator, you'll see a pretty straightforward class. It has two instance variables (name and power), a constructor, and getters and setters for each. I could take away the setters if I don't think a name or power should change, but having read enough comics or seen enough movies, we all know that those things can change. At some point, a super villain will probably take away a power, or a superhero might forego their name because they're not worthy anymore or something like that. 

Regardless, the important thing about this class is that we are intentionally building it as something generalized that can hold code that a lot of other classes will share. For instance, we are going to make Thor, Black Widow, and Hulk classes. They will all inherit from this Avenger base class, which means they will all get this code from Avenger.java without us having to write it multiple times.


### Black Widow

If you open up the BlackWidow.java file, you'll see another straightforward class. In this case we don't have to declare any instance variables or getters or setters, because we are going to rely on the Avengers class for those. BlackWidow extends the Avenger class, so she IS A Avenger, and hence will have a name and a power. The only thing we have to care about is the constructor. Because the Avenger class can only be initialized via a constructor that accepts a name and power, BlackWidow needs to provide those. So we create a constructor in her class, and then use the "super" keyword to pass values to our parent constructor. In this case, we know what the name and power are, so we can hardcode them.

If you go to the Application.java file, you can see that we created a list of avengers and added BlackWidow to it. 

### Thor

Let's look at the Thor.java class. Ignore that Thor implements "Flyable" for now. This is similar to BlackWidow, but we have some more functionality in here. In particular, Thor is only powerful as long as he is "worthy"

Let's take a moment to appreciate how weird Thor is as a character. He flies because he can swing a hammer super fast so that it acts like a helicopter. And he can only lift this hammer if he's worthy to lift it. If you ever think you've had some bad ideas, just remember someone came up with this as a story. And somehow, it still works?

Regardless of if the hammer make sense, we can at least try to make the code make sense. Just like BlackWidow, we have a constructor and provide hardcoded values we know to our parent using the "super" keyword. In this case "Thor" and "Swinging Hammer Fast" ...  But we also care about whether or not Thor is worthy. By default, in the constructor we will set worthy to true.

Quick callout - notice how the getter for worthy is named "isWorthy" - remember when we name getters for boolean variables, we say "is" instead of "get"

We also want some slightly different behavior for "getPower()" - if Thor is not worthy, he doesn't have his power anymore. The magic hammer is angry at him and has helicoptered off to be on its own for a while. So we can override getPower() and specify that for Thor, we want to first check if he's worthy. If so, then return our parent's getPower() like normal. Otherwise, if Thor is no longer worthy, have him declare so into the console.

If you go to the Application.java file, you can see he gets added to the list too. This is again because Thor IS A Avenger. He is inheriting from Avenger. 

Go ahead and run the Application.java file (right click, Run Main).  You'll see that under the Thor example, when he is worthy, it prints out his power. After we set worthy to false tho, then we get a different result in the console.

### Hulk

Take a look at the Hulk.java class. In this case, Hulk is more specific than Avenger, but still kind of general. Are we talking about Bruce Banner, or She-Hulk? In this case, they have the same power - so we can hardcode that - but they have different names. Because we don't know the name specifically, we can make that a parameter that the Hulk class accepts.

I also added a method specific to Hulk - smash()

Take a look at the IncredibleHulk.file. In this case, we're specifying this is Bruce Banner, the Incredible Hulk. We extend Hulk and then call its constructor, specifying the name.

Now look at SheHulk.java. In this case, we're we're specifying this is She-Hulk. We extend Hulk and then call its constructor, specifying the name.

Take a look at Application.java.  Notice IncredibleHulk and SheHulk are now being added to our avengers list after the Thor example.

Important callout: IncredibleHulk IS A Hulk and IS A Avenger. SheHulk IS A Hulk and IS A Avenger.

### Flyable

Take a look at Flyable.java.  This is an interface. An interface is similar to a class in that we are creating it as a new data type. So we will be able to create variables that are of type Flyable. 

However, interfaces only have method declarations, but no code bodies. All an interface says is that for a class to implement this interface, it needs to fill in all these methods. 

Interfaces are another way we can organize things into groups. Even if classes have nothing else in common, an interface indicates that they can DO similar things. 

For instance, in Flyable, we have one method fly()

If you look at both IronMan.java, Thor.java, and Airplane.java, all of these are flyable. They DO a common thing (fly) even tho they are completely different (although Thor and a Helicopter are more similar than we might initially think).

Notice in Application.java we add Ironman to the avengers list now.

### Avenger's, Assemble

Now continue scrolling down in Application.java. Notice after the "BEGINNING OF AVENGERS EXAMPLE" that we have a foreach loop to iterate through each avenger. The list only knows each of these variables as type Avenger. It does not know if one is Thor, BlackWidow, or IronMan. Since they are avengers, we know for sure they each have a getName() and getPower()

THIS IS POLYMORPHISM!!!  We wrote some generic code that tells the Avengers to state their name and power. Even tho only know each of these variables as type Avenger, they are each going to act specific to who they are. Black Widow will say her name and power. Same with Thor. Iron Man. On and on. When we say that polymorphism means "many forms" - this is what we mean. We can have objects that can be treated as many different data types: Thor IS A Avenger. Iron Man IS A Avenger and IS A Flyable.  She-Hulk IS A Hulk and IS A Avenger. 

But what if we want to do something specific? Make Thor worthy again? Let the Hulks smash()? And let the flyers fly? 

Here is where we can use a new Java keyword: instanceof.  This will only be true if our variable is an instance of a specific data type we give it. If we confirm that we are looking specifically at Thor, we can cast our Avenger variable to type Thor, and then we have access to all of the methods specific to Thor. Same with Hulk and Flyable. Take a look, it's just like casting from a double to an int.

Run the code and notice what outputs each hero has in the console and why.