/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

function multiplyFromArguments(){

  let product = 1;
  for(let i = 0; i < arguments.length; i++) {
    //product = product * arguments[i];
    product *= arguments[i];
  }

  return product;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyNoUndefined(firstParameter=0, secondParameter=0){
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

/**
 * 
 * @param {string} name the name of the person
 * @param {number} age the age of the person
 * @param {string[]} listOfQuirks a string array listing the quirks
 * @param {string} separator the character we want to use to separate everything
 * @returns {string} the full description of the person
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}



////////  FILTER EXAMPLE ////////////

/*
Given an array of strings, only return the ones that start with C
*/

function filterNames( namesArray ) {

 /*
  const namesThatStartWC = [];

  for(let i=0; i < namesArray.length; i++) {

    //check if it starts with C
    const isValid = namesArray[i].startsWith("C");

    if(isValid) {
      namesThatStartWC.push(namesArray[i]);
    }

  }

  return namesThatStartWC;
  */

  return namesArray.filter(
    (currentItem) => {
      return currentItem.startsWith("C");
    }
  )

}

////////// LOOP EXAMPLE /////////////
function printOutValues(valuesArray) {

  /*
  for(let i = 0; i < valuesArray.length; i++) {
    console.log(valuesArray[i]);
  }
*/

  valuesArray.forEach(
    (x) => {
      console.log(x);
    }

  );


}

//////// FIND ////////////////////////
const pets = [
  {
    petName: "Fluffy",
    petType: "Dog"
  },
  {
    petName: "Salem",
    petType: "Cat"
  },
  {
    petName: "Timber",
    petType: "Ferret"
  }
]

function findCat( petsArray ) {

  /*
  for(let i = 0; i < petsArray.length; i++) {

    if(petsArray[i].petType === "Cat") {
      return petsArray[i];
    }

  } */

  return petsArray.find(
    (pet) => {
      return pet.petType === "Cat";
    }
  )

}

function findPetStartsAndEnds(startsWithLetter, endsWithLetters) {

  return pets.find(
    (pet) => {
      return pet.petName.startsWith(startsWithLetter) && 
             pet.petName.endsWith(endsWithLetters);
    }
  )

}


//////// MAP ///////////////////////////////

function mapPetToString( petsArray ) {

  /*
  const petsStringArray = [];
  for(let i = 0; i < petsArray.length; i++) {

    const pet = petsArray[i];
    const petString = pet.petName + " (" + pet.petType + ")";
    petsStringArray.push(petString);

  }

  return petsStringArray;
  */

  return petsArray.map(
    (pet) => {
      return pet.petName + " (" + pet.petType + ")";
    }
  );
}


/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  /*
  let sum = 0;
  for(let i = 0; i < numbersToSum.length; i++){
    sum += numbersToSum[i];
  }

  return sum;
  */

  //Reduce = takes our whole array and reduces it to a single value
  return numbersToSum.reduce(
    (previousValue, currentValue) => {
      return previousValue + currentValue;
    }, 0
  );
}

function combineAllPets(petsArray) {
  return petsArray.reduce(
    (previousValue, currentValue) => {
      return previousValue + " " + currentValue.petName;
    }, ""

  );
}

