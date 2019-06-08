import Vuex from 'vuex'
import Vue from 'vue'
Vue.use(Vuex)




export default new Vuex.Store({
  state: {
    servidor_escolhido: {}
  },

  mutations: {
    change(state, servidor_escolhido) {
      state.servidor_escolhido = servidor_escolhido
    }
  },

  getters: {
    servidor_escolhido: state => state.servidor_escolhido
  }
})