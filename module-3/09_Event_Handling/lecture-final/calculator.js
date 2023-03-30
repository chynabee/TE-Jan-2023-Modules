
//DOMContentLoaded - the event that is broadcast when the page
//has finished loading. The reason this is important is because
//we want to make sure the HTML elements we are retrieving
//with javascript will already exist on the page
document.addEventListener('DOMContentLoaded', (event) => {
    
    const btnCalculate = document.getElementById("btnCalculate");
    
    //addEventListener accepts the event we are listening
    //for as the first parameter, and then the function
    //we want to run once that event occurs
    btnCalculate.addEventListener('click', multiplyNumbers)
});


// every function that gets called from an event listener
// will recevie the event as the first parameter
function multiplyNumbers(event){

    //by default the page is refreshing because the form is 
    //trying to submit to an api because we clicked on a button
    //inside the form.
    //To prevent this default behavior, we will tell the event
    //to prevent default
    event.preventDefault();

    const firstInput = document.getElementById("firstNum");
    const secondInput = document.getElementById("secondNum");

    const result = firstInput.value * secondInput.value;

    const span = document.getElementById("result");
    span.innerText = result;

}