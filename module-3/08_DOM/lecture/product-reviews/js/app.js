const bookName = 'Bigfoot Hunting For Dummies';
const description = 'Tired of people on History Channel having all the fun?';
const reviews = [
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
];

/**
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {}

/**
 * Add the product description to the page.
 */
function setPageDescription() {}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
