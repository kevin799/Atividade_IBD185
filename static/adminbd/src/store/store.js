import Vuex from 'vuex'
import Vue from 'vue'
import VuexPersist from 'vuex-persist'
Vue.use(Vuex)

// Ao usar dentro do componente banco ou Home,
// vai usar dessa forma: this.$store.state - depois de importar e instanciar 

const state = { //esse é a variavel state que criei, mas pode criar outras se quiser
  servidor_escolhido: {}
}

// Acesso a essa variavel dentro dos componentes: this.$store.jonta
// const jonta = {
//   resposta : 'Do you believe?'
// }

const vuexPersist = new VuexPersist({
  key: 'my-sec-app',
  storage: localStorage
})


export default new Vuex.Store({

  plugins: [
    vuexPersist.plugin
  ],
  state: {
    usuario: null,
    token: null
  },
  
// As mutations é o tipo de area que o VUEX faz as alterações das variaveis ou executam metodos
  mutations: {
    //Pra fazer uma alteração, pe preciso realizar o commit,
    // voce pode ver isso no componente Home dentro da funcao openInfoServ
    //usando assim: this.$store.commit('change',server) - com os parametros
    change(state, servidor_escolhido) {
      //adicionando na variavel criada la em sima os dados recebidos
      state.servidor_escolhido = servidor_escolhido
      // console.log("STORE: ")
      // console.log(state.servidor_escolhido);
    },

    setUsuario (state, usuario) {
      console.log(`Adicinando Usuario = ${usuario}`)
      state.usuario = usuario
    },
    setToken (state, token)  {
      console.log(`Adicinando Token = ${token}`)
      state.token = token
    },
    logout (state) {
      state.token = null
      state.usuario = null
    }
  },

  getters: {
    servidor_escolhido: state => state.servidor_escolhido
  },

})