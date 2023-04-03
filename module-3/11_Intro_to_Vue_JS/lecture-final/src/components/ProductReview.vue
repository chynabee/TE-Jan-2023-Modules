<template>
<div class="main">
  <!-- In the template section, there has to be one root element
  that everything else is inside. Typically we just make this a div -->
    <h2>Product Reviews for {{ name }}</h2>
   <!-- <input type="text" v-model="name" /> -->
    <p> {{ description }}</p>

    <div class="well-display">
        <div class="well">
            <span class="amount">{{averageRating}}</span>
            Average Rating
        </div>
        <div class="well">
            <span class="amount">{{numOf1StarReviews}}</span>
            1 Star Rating
        </div>
        <div class="well">
            <span class="amount">{{numOf2StarReviews}}</span>
            2 Star Rating
        </div>
        <div class="well">
            <span class="amount">{{numOf3StarReviews}}</span>
            3 Star Rating
        </div>
        <div class="well">
            <span class="amount">{{numOf4StarReviews}}</span>
            4 Star Rating
        </div>
        <div class="well">
            <span class="amount">{{numOf5StarReviews}}</span>
            5 Star Rating
        </div>
    </div>

    <!-- v-bind before any attribute means that in the quotes of that attribute
    we will now be treating it as javascript.  Additionally, to apply a class
    based on a condition, we will put curly braces, and then the name of our css
    class followed by a : followed by the condition we are checking is true  -->
    <div class="review" v-bind:class="{ favorited: review.favorited}" 
    v-for="review in reviews" v-bind:key="review.id">
        <h4>{{ review.reviewer }}</h4>
        <div class="rating"> 
            <img v-for="star in review.rating" v-bind:key="star"
                class="ratingStar" src="../assets/star.png" title="Stars Review" />
        </div>
        <h3>{{review.title}}</h3>
        <p>{{review.review}}</p>
        Favorited? <input type="checkbox" v-model="review.favorited" />
    </div>

</div>
</template>

<script>
export default {
    name: "product-review",
    data() {
        return {
            // Think of these as if they are private variables 
            // in your java class
            name: "Bigfoot Hunting for Dummies",
            description: "History channel can't have all the fun - can they?",
            reviews: [
                {
                    id:1,
                    reviewer: "Christopher",
                    rating: 4,
                    title: "This book changed my life",
                    review: "Once I finally found bigfoot my life was complete. He is now my roomate.",
                    favorited: false
                },
                {
                    id:2,
                    reviewer: "Craig",
                    rating: 3,
                    title: "Book was mid",
                    review: "Title was a lie, he should be called big feet",
                    favorited: false
                }
            ]
        }
    },
    computed: {
        /* Think of these like derived properties from Java, where we calculate
        the value on the fly */
        averageRating() {

            let sum = 0;

            //To refer to other variables and methods inside of our script, use 
            //the this keyword just like java
            for(let review of this.reviews) {
                sum += review.rating;
            }

            return sum / this.reviews.length;
        },
        numOf1StarReviews(){

            let count = 0;
            for(let review of this.reviews){
                if(review.rating == 1) {
                    count++;
                }
            }

            return count;
        },
        numOf2StarReviews(){

            let count = 0;
            for(let review of this.reviews){
                if(review.rating == 2) {
                    count++;
                }
            }

            return count;
        },
        numOf3StarReviews(){

            let count = 0;
            for(let review of this.reviews){
                if(review.rating == 3) {
                    count++;
                }
            }

            return count;
        },
        numOf4StarReviews(){

            let count = 0;
            for(let review of this.reviews){
                if(review.rating == 4) {
                    count++;
                }
            }

            return count;
        },
        numOf5StarReviews(){

            let count = 0;
            for(let review of this.reviews){
                if(review.rating == 5) {
                    count++;
                }
            }

            return count;
        }
    }
}
</script>

<style scoped>
/* scoped (above) means that the css below will only apply to the
HTML defined in this component and not affect anything else on the page*/

.main .review.favorited {
    background-color: yellow;
}

.main {
    margin: 15px;
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
</style>