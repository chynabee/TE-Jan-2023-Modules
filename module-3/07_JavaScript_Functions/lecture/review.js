

function evenOnly(numbersArray) {
    //declare an empty array
    //remember const means the evens variable cannot be reassigned to something else.
    //but we can still update/add/remove contents from the array itself.
    const evens = [];

    //initialize it     condition       iterator
    for(let i=0; i < numbersArray.length; i++) {

        const currentNumber = numbersArray[i];

        //we use the % sign to get the remainder leftover after dividing by 2.
        const remainder = currentNumber % 2;

        if(remainder === 0) {
            //because there is no remainder we know this is an even number.
            //so we will add it to our new array and then look at the next number.
            evens.push(currentNumber);
        }
    }
    return evens;
}