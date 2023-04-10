<template>
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

    }
}
</script>

<style>

</style>
