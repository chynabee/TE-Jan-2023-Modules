

function evenOnly(numbersArray) {

    //declare an empty array
    //remember const means the evens variable cannot be reassigned to something else,
    //but we can still update/ add/ remove contents from the array itself
    //const evens = [];
    

    //init    condition     iterator
  /*  for(let i =0; i < numbersArray.length; i++) {

        const currentNumber = numbersArray[i];

        //we use the % to get the remainder leftover after dividing by 2
        const remainder = currentNumber % 2;

        if(remainder === 0) {
            //because there is no remainder we know this is an even number
            // so we will add to our new array and then look at the next number
            evens.push(currentNumber);
        }
    } */

    /*
    for(let currentNumber of numbersArray) {

        //we use the % to get the remainder leftover after dividing by 2
        const remainder = currentNumber % 2;

        if(remainder === 0) {
            //because there is no remainder we know this is an even number
            // so we will add to our new array and then look at the next number
            evens.push(currentNumber);
        }

    }
    */

    //filter with anonymous function
    let filteredEvens = numbersArray.filter( 
            //anonymous function - no name
            (num) => {
                return num % 2 == 0;
            } 
        );

    // filter with named function   
    let filteredOdds = numbersArray.filter( isOdd );

    return filteredEvens;
}



function isOdd(num) {
    return num % 2 == 1;
}


function getFirstTwo( value ) {

    //Substring is similar to java, we give the starting index and then the 
    //index we got up to but don't include
    return value.substring(0, 2);
}

function getLastTwo( value) {
    return value.substring( value.length - 2);
}