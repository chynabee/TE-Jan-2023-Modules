import axios from 'axios';

//this is similar to in java when we created a restTemplate
//and made http calls from it
const http = axios.create(
    { baseURL: "https://api.nasa.gov/planetary/apod"}
)

const apiKey = "?api_key=kvP8HbeS2OA5VcMNo5WMB9c5yV6jAF5xuvG4GuBl";

//Similar to Java, we can group all the code that our client uses
//to make a request and send it to the server as a "service"
export default {

    //Everything that we export will be available to any other file
    //that imports this file. So other files will be able to to call
    //getPicOfTheDay, but they will not be able to call http directly
    getPicOfTheDay(){

        //The .get() does not return the results from NASA, but instead
        //returns a Promise. Think of this like when you go to a 
        //restaurant and have a wait, and they give you a device
        //that will notify you when your table is ready. Similarly,
        //the promise will come back and let us know when we've 
        //received a response from NASA
        return http.get(apiKey);
    },
    searchByDay(date) {
        const url = apiKey + "&date=" + date;
        return http.get(url);
    }

}