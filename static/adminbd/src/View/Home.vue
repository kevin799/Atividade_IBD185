<template>
  <div class="home">
    <div class="title">
      <div class="container-fluid mt-1 bg-dark p-3 d-flex justify-content-between">
        <div></div>
        <h1>Servers</h1>
        <div>
             
        </div>
      </div>
    </div>
  

    <div class="container">
        <div class="add-serve border border-dark" id="add-serve">
            <h1 class="title"><p>Adicionar</p></h1>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1" v-model="server.nome">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="IP Address" aria-label="Ip" aria-describedby="basic-addon1" v-model="server.ip">
                <select class="custom-select mt-2 mr-3" id="inputGroupSelect01" v-model="server.maquina">
                    <option selected>Machine</option>
                    <option value="1">AWS</option>
                    <option value="2">Digital Ocean</option>
                    <option value="3">Red Hat</option>
                </select>  
            </div>

            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Processor" aria-label="Processor" aria-describedby="basic-addon1" v-model="server.processador">
            </div>
      
            <div class="input-group mb-3">
                <input type="number" class="form-control" placeholder="Memory" aria-label="Memory" aria-describedby="basic-addon1" v-model="server.memoria">
                <input type="number" class="form-control" placeholder="Space" aria-label="Space" aria-describedby="basic-addon1" v-model="server.espaco">
            </div>

            <div class="d-flex justify-content-center">
                <button type="button" class="btn btn-danger btn-lg" v-on:click="noneElemento()">Cancel</button>
                <button type="button" class="btn btn-success btn-lg" v-on:click="createServe()">Include</button>
                
            </div>
        </div>


        <div class="d-flex flex-row">
            <div class="input-group mb-3 col-4 mx-auto">
                <input type="text" class=" mt-3 form-control" placeholder="Search Server" v-model="search">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary mt-3" type="button" id="search-serve" v-on:click="getAllServidores()">Search</button>
                </div>
            </div>
            <div style="width: 100px">
                <button type="button" class="btn-plus btn btn-info w-100 mt-3" v-on:click="blockElemento">+</button>
            </div>
        </div>    
        <table class="table">
            <thead class="thead bg-dark text-light">
                <tr>
                    <th class="text-center border-right">Name</th>
                    <th class="text-center border-right">IP</th>
                    <th class="text-center border-right ">Status</th>
                </tr>
            </thead>
            <tbody class="tbody">
                <tr class="servs" v-for="server in this.servidores" :key="server.id">


                    <!-- <th id="servs" class="text-center" v-on:click="openInfoServ"> sla</th>
                    <th class="text-center"> 192.168.1.2</th>
                    <th class=" text-center"> <button type="button" class="btn btn-success" id="btn-status" v-on:click="habiServiButton">√</button></th> -->
               
                        <th id="servs" class="text-center"  v-on:click="openInfoServ(server)">  {{server.nome}} </th>
                        <th class="text-center"> {{server.ip}} </th>
                        <th class=" text-center" >
                            <div v-if="server.status == 1">
                                <button type="button" class="btn btn-success" id="btn-status" > √</button>
                            </div>
                            <div v-else>
                                <button type="button" class="btn btn-danger" id="btn-alert"> X</button>
                            </div>
                        </th> 

                </tr>
            </tbody>
            <tfoot>
                <th>Total: {{this.total}}</th>
            </tfoot>
        </table>
    </div>

  </div>
</template>


<script>
import { store } from '../store/store'

export default {
    component: {
        store
    },
    data() {
    return {
        search: '',
        servidores: '',
        total:'',
        server:{
            ip: '',
            nome: '',
            maquina:'',
            processador: '',
            memoria: '',
            espaco: '',
            status: 1,
            
        }


    }
  },
    mounted(){
        this.getAllServidores()
        // this.habiServiButton()
        // this.openInfoServ()
        // Popula os dados na tela para lista de servidores
        
        

      
    },
    methods:{
        blockElemento(){
  
            document.getElementById('add-serve').style.display = 'block'


        },
        noneElemento(){
        
            document.getElementById('add-serve').style.display = 'none'
         
        },
      
    
        habiServiButton(){

            // const btn = document.getElementById("btn-status");
            // if (btn.innerHTML == '√'){
            //     btn.addEventListener("click", () => {
            //     btn.style.backgroundColor = "red"
            //     btn.innerHTML = 'X'
                
            
            //     })
            // }
            //  if (btn.innerHTML == 'X'){
            //     btn.addEventListener("click", () => {
            //     btn.style.backgroundColor = "green"
            //     btn.innerHTML = '√'
            //     })     
            // }  
        },

        openInfoServ(server){
            this.$store.commit('change',server)
            // console.table(server)

            this.$router.push({ path: 'banco'})
 
        },
        getAllServidores(){
            if (this.search === ''){
            this.$http.get('http://localhost:8082/springRest/servidorPrincipal/getAll')
            .then(res =>{
            this.servidores = res.data;
            
            })
            }
            else{
                  this.$http.get('http://localhost:8082/springRest/servidorPrincipal/getByIp?ip='+this.search)
             .then(res => {
            this.servidores = res.data;
            
            
            })
            }
            this.total = this.servidores.length

        },
        createServe(){
            var params = {
                    "ip": this.server.ip,
                    "nome": this.server.nome,
                    "maquina" : this.server.maquina,
                    "processador": this.server.processador,
                    "memoria": this.server.memoria,
                    "espaco" : this.server.espaco,
                    "status": this.server.status

                }
                if(params.nome === '' || params.ip === '' || params.maquina === '' 
                    || params.processador === '' || params.memoria === '' || params.espaco === ''
                    || params.status === '') console.log("erro ao salvar")
                else{
                    this.$http.post(`http://localhost:8082/springRest/servidorPrincipal/save`, params)
                    .then(response => {
                    // JSON responses are automatically parsed.
                    // this.response = response.data
                    // this.banco.id = response.data
                    console.log(response);
                    // this.showResponse = true
                    })
                    this.noneElemento()
                }
        }      
    }
}
</script>

<style>
.home{
    background: rgb(150, 149, 149);
    height: 100vh;
    width: 100%;
}
    .thead{
        font-family: roboto;
    }

    .btn-plus{
        padding: 10px;
    }
    .tbody{
        background: #d0d5db;
    }
*{
  font-family: 'Open Sans', sans-serif;
  
}
.add-serve{
  display: none;
  margin-top: 16px;
  margin-left: 20%;
  position: absolute;
  height: 75%;
  width: 35%;
  color: #fff;
  background: #e0e4e9;
  z-index: 1000;
}

.servs{
    transition: .5s;
}
.servs:hover{
    background: #656769;;
    transition: .5s;
}
.add-serve p{
  color: white;
  display: flex;
  padding: 2px;
  justify-content: center;

}
.form-control{
  margin: 10px;
}

.btn .btn-primary .btn-lg{
  background-color: #fff;
}

.title{
    background: rgb(39, 43, 48);
}
  
</style>
