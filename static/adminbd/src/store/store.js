import Vuex from 'vuex'
import Vue from 'vue'
Vue.use(Vuex)

const state = {
  servidor_escolhido: {}
}


export default new Vuex.Store({


  

  mutations: {
    change(state, servidor_escolhido) {
      state.servidor_escolhido = servidor_escolhido
      console.log("STORE: ")
      console.log(state.servidor_escolhido);
    }
  },

  getters: {
    servidor_escolhido: state => state.servidor_escolhido
  },

})