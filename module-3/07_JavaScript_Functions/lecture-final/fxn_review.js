

/**
 *  public int multiply(int number1, int number2){
 *  return number1 * number2;
 * }
 * 
 */
function multiply(number1, number2){
    return number1 * number2;
}

function isDivisibleBy3(num) {
    return num % 3 === 0;
}



function filterArray( numbersArray) {

  //  return numbersArray.filter(isDivisibleBy3);

    return numbersArray.filter( (num) => {
        return num < 10;
    } );

}



function printArray(numberArrays){

    numberArrays.forEach(
        (num) => {
            console.log(num);
        }
    )

}

function example() {

    let myNum = -5;
    let newNum = Math.abs(myNum);

    let newNum2 = Math.abs(-5);

}

const names = ['Christopher', 'Craig', 'Sam'];

function mapNames( ) {

    return names.map(
        (name) => {
            return "Hello, " + name + "!"
        }
    )

}


function reduceExample(numbersArray) {

    /*
    let product = 1;
    for(let num of numbersArray) {
        product *= num;
    }

    return product;
    */

    return numbersArray.reduce(
        (product, num) => {
            return product * num;
        }, 1
    )

}
