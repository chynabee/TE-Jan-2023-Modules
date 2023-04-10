import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../views/Products.vue'
import ProductDetails from '../views/ProductDetails.vue'

Vue.use(VueRouter)

const routes = [
  //1. path- route we are matching from the URL
  //2. what we want to name the route(anything we want)
  //3. components we want to display for this route
  {
    path:"/",
    name:"home",
    component:Products
  },

  {
    path:"/products/:id",
    name:"product-details",
    component:ProductDetails
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
