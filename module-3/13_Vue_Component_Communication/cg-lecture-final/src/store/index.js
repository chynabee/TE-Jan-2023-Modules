import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    reviews: [
      {
        reviewer: 'Malcolm Madwell',
        title: 'What a book!',
        review:
        "10,000 hours later, I can declare I am the best Bigfoot hunter there ever was!",
        rating: 3
      },
      {
        reviewer: 'Tim Ferriss',
        title: 'I found Bigfoot in less than 4 hours.',
        review:
          "It should have been called the four hour Bigfoot hunt. ",
        rating: 4
      },
      {
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneur needs.',
        review:
          "After finding Bigfoot, you will feel empowered to start your own business.",
        rating: 1
      },
      {
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. If we love and embrace the mysteries of life, aren't we all hunting Bigfoot?",
        rating: 3
      }
    ]
  },
  getters: {
  },
  mutations: {
    //By convention, we always name mutations in all caps
    //The first parameter for each mutation will always be state
    ADD_REVIEW(state, review){
      state.reviews.unshift(review);
    }
  },
  actions: {
  },
  modules: {
  }
})
