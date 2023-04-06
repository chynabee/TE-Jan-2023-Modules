import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../views/Products.vue'
import ProductDetails from '../views/ProductDetails.vue'
import AddReview from "../views/AddReview.vue"
Vue.use(VueRouter)

const routes = [
  // The three things we want to define for a route:
  // 1. The route we are matching from the URL
  // 2. We want to give a name to this route (anything we want that hasn't already been used)
  // 3. The components we want to display for this route
  {
    path: "/",
    name: "home",
    component: Products
  },
  {
    path:"/products/:id",
    name: "product-details",
    component: ProductDetails
  },
  {
    path:"/products/:id/add",
    name: "add-review",
    component: AddReview
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
