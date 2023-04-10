<template>
<<<<<<< HEAD
    <div>
        <h1>{{ picOfTheDay.title }}</h1>
        <p>{{ picOfTheDay.explanation }}</p>
        <img v-bind:src="picOfTheDay.url" />

    </div>
</template>


<script>
import { AstronomyService } from '../services/AstronomyService.js'

export default {
    name: "astronomy",
    data() {
        return {
            picOfTheDay: {}
        }
    },

    created() {
        AstronomyService.getPicOfTheDay().then (
            (response) => {
                this.picOfTheDay = response.data;
            }
        )

=======
  <div>
      <div v-if="isLoading">
          <img src="../assets/ping_pong_loader.gif" />
      </div>
      <div v-if="!isLoading">
        <h1>{{ picOfTheDay.title }}</h1>
        <h2>{{ picOfTheDay.copyright + ' - ' + picOfTheDay.date}} </h2>
        <p>{{picOfTheDay.explanation}}</p>
        <img v-bind:src="picOfTheDay.url" />

        <form v-on:submit.prevent="searchByDay()">
            <h3>Search other days</h3>
            <input type="date" v-model="dateSelected" />
            <input type="submit" value="Search" />
        </form>
      </div>
  </div>
</template>

<script>
import AstronomyService from '../services/AstronomyService.js'

export default {
    name: "astronomy",
    data(){
        return {
            isLoading: true,
            picOfTheDay: {},
            dateSelected: null
        }
    },
    //This is a lifecycle hook, as soon as the component is created
    //it will run this code automatically
    created() {
        console.log("Before our service call");
        AstronomyService.getPicOfTheDay().then(
            (response) => {
                console.log("We have received a response");
                this.picOfTheDay = response.data;
                this.isLoading = false;
            }
        )
        console.log("After our service call");
    },
    methods: {
        searchByDay() {
            if(this.dateSelected != null){
                console.log(this.dateSelected);
                this.isLoading=true;
                AstronomyService.searchByDay(this.dateSelected).then(
                    (response) => {
                        this.picOfTheDay = response.data;
                        this.isLoading=false;
                    }
                );
            }
        }
>>>>>>> 9f2bf5555fcab53c9348f66d450a519547c0e6ad
    }
}
</script>

<style>
<<<<<<< HEAD

</style>
=======
img {
    width: 350px;
}
</style>
>>>>>>> 9f2bf5555fcab53c9348f66d450a519547c0e6ad
