<template>
  <form @submit.prevent="login">
    <h2>Login</h2>
    <div class="form-group">
      <label for="username">Usuário</label>
      <input type="text" id="username" class="form-control" required autofocus v-model="username" >
    </div>
    <div class="form-group">
      <label for="inputPassword">Senha</label>
      <input type="password" id="inputPassword" class="form-control" required v-model="password" >
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Ok</button>
  </form>
</template>

<script>
// import axios from 'axios'
// import { mapMutations } from 'vuex'



export default {
  name: 'login',
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {

    login () {
        this.$http.post('http://localhost:8082/springRest/login', 
            {username: this.username, password: this.password})
            .then(res => {
            // console.log(res)
            this.$router.push({ path: 'home'})
            })
            .catch(error => {
            // console.log(error)
            })
        }

  }
    

}
</script>