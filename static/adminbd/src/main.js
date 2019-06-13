import Vue from 'vue'
import App from './App.vue'
import router from './Router'
import axios from 'axios'
import store from './store/store'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'


axios.defaults.baseURL = 'http://localhost:8082/springRest'

axios.interceptors.request.use(config => {
  if(store.state.token) {
    //Login com uscesso passa-se por aqui
    config.headers.Authorization = store.state.token
  }
  return config
})
axios.interceptors.response.use(res => {
    //Verifica cada pagina entrada para verificar o usuario
    // if (store.state.token){
    //   return res
    // }
    return res
    // console.log(res)
    // alert('Usuario nao autorizado!')
    return null
  }, error => {
    if(error.response.status === 403) {
      alert('Não autorizado!')
    }
    else if (error.response.status === 401) {
      store.commit('logout')
      router.push('/')
    }
    throw error
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
