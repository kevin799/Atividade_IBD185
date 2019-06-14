<template>
<body>
  <form @submit.prevent="login">
<div class="form bg">
  <div class="forceColor"></div>
  <div class="topbar">
    <div class="spanColor"></div>
    
    <input type="text" class="input" id="username" placeholder="Usuário" required autofocus v-model="username"/>
    <input type="password" class="input" id="password" placeholder="Password" required v-model="password" />
    
  </div>
  <button class="submit" id="submit" >Login</button>
</div>
  </form>
</body>
</template>

<script>
import axios from 'axios'
import { mapMutations } from 'vuex'



export default {
  name: 'login',
  data() {
    return {
      username: '',
      password: ''



      // Inicio Tela Login


      // Fim Tela Login
    }
  },
  methods: {

    ...mapMutations([
      'setUsuario',
      'setToken'
    ]),

    login () {
        axios.post('/login', 
            {username: this.username, password: this.password})
            .then(res => {
            // console.log(res)
            this.setUsuario(res.data)
            this.setToken(res.headers.token)
            this.$router.push({ path: 'home'})
            })
            .catch(error => {
            console.log(error) 
            })
        }

  }
    

}
</script>

<style scoped>

body {
  font-size: 62.5%;
  width: 100%;
  height: 100%;
  position: absolute;
  font-family: Raleway;
  background: url('../assets/vizimalia.jpg') no-repeat fixed;
  background-size: cover;
  background-position: 50%;
  -webkit-font-smoothing: antialiased;
}

.form {
  margin: 0 auto;
  position: fixed;
  top: 35%;
  left: 50%;
  -moz-transform: translate3d(-50%, 0, 0);
  -ms-transform: translate3d(-50%, 0, 0);
  -webkit-transform: translate3d(-50%, 0, 0);
  transform: translate3d(-50%, 0, 0);
  width: 350px;
  padding: 20px;
  overflow: hidden;
  background-color: black;
  border: 1px solid rgba(255, 255, 255, 0.5);
  background: inherit;
  -moz-border-radius: 12px;
  -webkit-border-radius: 12px;
  border-radius: 12px;
}

.form .forceColor {
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
  background-color: rgba(0, 0, 0, 0.4);
}

.form .topbar .input {
  display: block;
  width: 100%;
  position: relative;
  border-top-left-radius: 6px;
  border-bottom-left-radius: 6px;
  border-top-right-radius: 6px;
  border-bottom-right-radius: 6px;
  font-size: 1rem;
  background: transparent;
  border-top: 1px solid rgba(255, 255, 255, 0.4);
  border-left: 1px solid rgba(255, 255, 255, 0.4);
  border-bottom: 1px solid rgba(255, 255, 255, 0.4);
  border-right: 1px solid rgba(255, 255, 255, 0.4);
  margin-bottom: 25px;
  color: rgba(255, 255, 255, 0.4);
  padding: 10px 20px;
}

.form .submit {
  padding: 10px 20px;
  width: 100%;
  font-size: 1.2rem;
  font-family: Raleway;
  font-weight: 200;
  display: block;
  color: white;
  position: relative;
  border: 1px solid rgba(255, 255, 255, 0.4);
  background: rgba(255, 255, 255, 0.5);
  -moz-border-radius: 6px;
  -webkit-border-radius: 6px;
  border-radius: 6px;
  cursor: pointer;
}

</style>