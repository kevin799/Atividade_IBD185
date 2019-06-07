import Vue from 'vue'
import App from './App.vue'
import router from './Router'
import axios from 'axios'
import store from './store/store'

Vue.prototype.$http = axios

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
