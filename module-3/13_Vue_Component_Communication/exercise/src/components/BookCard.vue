<template>
  <div class="card">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img class="book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'"/>

    <button class="mark-read" 
      v-if="book.read == false" 
      v-on:click="onReadUnreadChange"> 
      {{ book.read === true ? "Mark Unread" : "Mark Read" }} 
    </button>

    <button
      class="mark-unread"
      v-if="book.read == true"
      v-on:click="onReadUnreadChange">
      {{ book.read === true ? "Mark Unread" : "Mark Read" }}
    </button>

  </div>
</template>

<script>
export default {
  name: "book-card",
  props: ["book"],
  methods: {
    onReadUnreadChange() {
      this.$store.commit("TOGGLE_READ_UNREAD", this.book);
    },
  },
};
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}
.card.read {
  background-color: lightgray;
}
.card .book-title {
  font-size: 1.5rem;
}
.card .book-author {
  font-size: 1rem;
}
.book-image {
    width: 80%;
}
</style>
