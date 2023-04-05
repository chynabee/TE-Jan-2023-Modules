<template>
  <div class="main">

<!--
    <a v-on:dblclick="helloWorld('Christopher')">Say Hello</a>
-->
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <star-summary v-bind:numOfReviews="filterReviews(1)" rating="1" />
      <star-summary v-bind:numOfReviews="filterReviews(2)" rating="2" />
      <star-summary v-bind:numOfReviews="filterReviews(3)" rating="3" />
      <star-summary v-bind:numOfReviews="filterReviews(4)" rating="4" />
      <star-summary v-bind:numOfReviews="filterReviews(5)" rating="5" />
     
    </div>
    <a v-show="!showForm"
     v-on:click.prevent="showForm = true">Show Form</a>
    <!-- For forms it has default behavior to submit the form and 
    refresh the page. Last week we had to call event.preventDefault()
    to stop that from happening. In Vue we can just say .prevent -->
    <form v-show="showForm"
      v-on:submit.prevent="addNewReview()">
      <div class="form-element">
        <label for="inName">Name</label>
        <input type="text" id="inName" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="inTitle">Title</label>
        <input type="text" id="inTitle" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="inRating">Rating</label>
        <select id="inRating" v-model="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Star</option>
          <option value="3">3 Star</option>
          <option value="4">4 Star</option>
          <option value="5">5 Star</option>
        </select>
      </div>
      <div class="form-element">
        <label for="inReview">Review</label>
        <textarea id="inReview" v-model="newReview.review" />
      </div>
      <input type="submit" value="Save" />
      <input type="button" v-on:click="resetForm()" value="Cancel" />
    </form>

    <reviews-list />
  </div>
</template>

<script>
import StarSummary from './StarSummary.vue'
import ReviewsList from './ReviewsList.vue'

export default {
  name: "product-review",
  components: {
    StarSummary, ReviewsList
  },
  data() {
    return {
      showForm: false,
      newReview: {
        reviewer: "",
        title: "",
        rating: 0,
        review: ""
      },
      name: "Bigfoot Hunting For Dummies",
      description:
        "Tired of people on History Channel having all the fun?",
      
    };
  },
  computed: {
    averageRating() {
      let sum = this.$store.state.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.$store.state.reviews.length).toFixed(2);
    }
  },
  methods: {
    filterReviews(rating) {
       return this.$store.state.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === rating);
      }, 0);
    },
    helloWorld(name){
      alert("Hello World and Hello " + name);
    
    },
    addNewReview(){
        this.newReview.rating = parseInt(this.newReview.rating);
        
        //We cannot write directly to state! we have to use
        // a mutation
        //this.$store.state.reviews.unshift(this.newReview);
        this.$store.commit("ADD_REVIEW", this.newReview);
        this.resetForm();
    },
    resetForm(){
      //I could go through and set each field to be empty
      //or I could make the whole object set to an empty object
      this.newReview = {};
      this.showForm = false;
    }
  }
};
</script>

<style>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input, div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type=button] {
  width: 100px;
}
form > input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>

