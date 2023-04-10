import axios from 'axios';

const http = axios.create(
    { baseURL: "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"}
)

export default {

    getPicOfTheDay() {
        return http.get();
    }
}