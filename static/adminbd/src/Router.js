import Vue from 'vue'
import Router from 'vue-router'
import Home from './View/Home.vue'
import Banco from './View/Banco.vue'
import Login from './View/Login.vue'
Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/banco',
      name: 'banco',
      component: Banco
    }
  
  ]
})
export default router