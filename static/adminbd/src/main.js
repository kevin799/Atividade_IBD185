import Vue from 'vue'
import App from './App.vue'
import router from './Router'
import axios from 'axios'

Vue.prototype.$http = axios

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
