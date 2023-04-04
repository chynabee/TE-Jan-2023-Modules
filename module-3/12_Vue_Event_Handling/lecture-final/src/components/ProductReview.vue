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

      <div class="well">
        <span class="amount">{{ filterReviews(1) }}</span>
        1 Star Review{{ filterReviews(1) === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ filterReviews(2) }}</span>
        2 Star Review{{ filterReviews(2) === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ filterReviews(3) }}</span>
        3 Star Review{{ filterReviews(3) === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ filterReviews(4) }}</span>
        4 Star Review{{ filterReviews(4) === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ filterReviews(5) }}</span>
        5 Star Review{{ filterReviews(5) === 1 ? '' : 's' }}
      </div>
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

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in reviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      showForm: false,
      newReview: {
        reviewer: "",
        title: "",
        rating: 0,
        review: ""
      },
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false
        }
      ]
    };
  },
  computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2);
    }
  },
  methods: {
    filterReviews(rating) {
       return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === rating);
      }, 0);
    },
    helloWorld(name){
      alert("Hello World and Hello " + name);
    },
    addNewReview(){
        this.newReview.rating = parseInt(this.newReview.rating);
        this.reviews.unshift(this.newReview);
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

<style scoped>
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

