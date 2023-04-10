<template>
  <div id="app" class="main">
      <router-link v-bind:to="{name: 'home' }">Back To Home</router-link>
      <h1>{{$store.getters.product.name}}</h1>
      <p class="description">{{$store.getters.product.description}}</p>
      <div class="well-display">
          <average-summary />
          <star-summary rating="1" />
          <star-summary rating="2" />
          <star-summary rating="3" />
          <star-summary rating="4" />
          <star-summary rating="5" />
    </div>
    <review-list />
    </div>
</template> 

<script>
import AverageSummary from '../components/AverageSummary.vue'
import StarSummary from '../components/StarSummary.vue'
import ReviewList from '../components/ReviewList.vue'

export default {
    components: {
        AverageSummary, StarSummary, ReviewList 
    },
    //This is a lifecycle hook. It will run this code immediately
    //when the component is created
    created(){
        const activeProductId = this.$route.params.id;
        this.$store.commit("SET_ACTIVE_PRODUCT", activeProductId)
    }
}
</script>

<style>

</style>