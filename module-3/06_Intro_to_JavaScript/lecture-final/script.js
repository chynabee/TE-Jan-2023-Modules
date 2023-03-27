/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */

/*
In java - a method includes more details, for instance a return type:
public String getName() {
  return name;
}

In javascript, it's called a function, and we don't declare an access modifier
(so no public or private) and we don't declare a return type. So in javascript
that method above would look like:

function getName() {
  return name;
}

*/


function variables() {
  // Declares a variable where the value cannot be changed
// If a variable is not going to be changed, we can make it a constant
const name = "Christopher";
console.log(name);

  // Declares a variable those value can be changed
let age = 38;
age = 39;
console.log(age);

  // Declares a variable that will always be an array
  const weekdays = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday"
  ];

  weekdays.push("Saturday");
  weekdays.push("Sunday");
  weekdays.push(7);
  weekdays.push(true);
 
  console.table(weekdays);
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);

  console.log("Param1 is " + typeof param1);
  console.log("Param2 is " + typeof param2);

  if(typeof param1 == "number" && typeof param2 == "number") {
    const result = param1 + param2;
    console.log("The result of adding these together is: " + result);
  }
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}


function demo() {
  let name = "Christopher";

  console.log(`Hello World, and Hello ${name}`);
  console.log("Hello World, and Hello " + name);
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = 
   {
      firstName: "Bill",
      lastName: "Lumbergh",
      age: 42,
      employees: [
        "Peter Gibbons",
        "Milton Waddams",
        "Samir Nagheenanajar",
        "Michael Bolton"
      ]
  };

  // Log the object
  console.table(person);

  // Log the first and last name
  console.log( person.firstName + " " + person.lastName);

  // Log each employee
  console.log("EACH INDIVIDUAL PRINT OUT:");
  console.log(person.employees[0]);
  console.log(person.employees[1]);
  console.log(person.employees[2]);
  console.log(person.employees[3]);

  //with a for loop
  console.log("PRINT OUT WITH FOR LOOP");
  for(let i = 0; i < person.employees.length; i++) {
    console.log(person.employees[i]);
  }

  //with a foreach loop
  console.log("PRINT OUT WITH FOREACH LOOP") 
  for(let employee of person.employees) {
    console.log(employee);
  }
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  console.log("Here in the first function")
  return num1 + num2;
}

function Add(num1, num2, num3) {
  console.log("Here in the second function")
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}

/*
########################
Array Methods
########################

*/
function arrayFunctions() {

//To declare an empty array 
const myArray = [];

//To declare an array with values out of the gate
const petsArray = ["dog", "cat", "ferret", "hamster"];

//if I want to add a new item at the end
petsArray.push("parrot");

//if I want to remove an item at the end
const lastElement = petsArray.pop();

console.log(lastElement);

//if we want to add an element at the beginning
petsArray.unshift("fish");

//if we want to remove an element at the beginning
petsArray.shift();

console.table(petsArray);

//if we want to check if an array contains an element we can use includes
console.log("Does our array include ferret? " + petsArray.includes("ferret"));
}