<template>
    <div class="main">
        <h2> Product Reviews for {{ name }}</h2>
        <p>{{ description }}</p>

        <div class="review">
            <h4>Reviewer</h4>
            <div class="ratting">
                <img class="ratingStar" src="../assets/star.png" title="Stars Review" />

    </div>
    <h3>Title of Review</h3>
    <p>Review itself</p>

    </div>

    </div>
</template>

<script>
export default { 
    name: "product-review",
    data() {
        return {
            name:"BigFoot Hunting for Dummies",
            description: "History channel can't have all the fun-can they?",
            reviews: [
                {
                    reviewer:"Christopher",
                    rating: 5,
                    title: "This book changed my life",
                    review:"Once I finally found bigfoot my life was complete. He is now my roommate."
                },
                {   reviewer:"Craig",
                    rating: 3,
                    title: "Book was mid",
                    review:"Title was a lie, he should be called big feet."

                }
            ]
        }
    }
}
</script>

<style scoped>
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


