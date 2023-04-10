setTimeout(() => {
    
    console.log("Running plugin");

    //We can manipulate the values on the screen
    document.querySelector(".sc-bde20123-1").innerText=10

    //We can manipulate the style on the screen to make it easier to read
    document.querySelector(".sc-5f699a2-1").style.fontSize="30px";
    document.querySelector(".sc-5f699a2-1").style.color="lightblue";

    //We can add new elements to the screen 
    const h2 = document.createElement("h2"); 
    h2.innerText="Graffiti"; 
    document.querySelector(".sc-5f699a2-1").appendChild(h2);

    //We can remove elements from the screen as well
    const stars = document.querySelectorAll('li[data-testid="title-pc-principal-credit"]:nth-child(3)')[0];
    stars.querySelector(".ipc-inline-list__item").remove();
},1500)