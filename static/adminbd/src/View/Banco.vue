<template>
  <div class="banco">
    <div class="title">
      <div class="container-title container-fluid mt-1 p-3 d-flex justify-content-between ">
        <div></div>
        <h1 class="mt-1">Database</h1>
        <div>
             
        </div>
      </div>
    </div>
  

    <div class="container"> 
        <div class="add-bd border border-dark" id="add-bd">
            <h1 class="title" id='add-title'><p>Adicionar</p></h1>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1" v-model="banco.name">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Type" aria-label="Type" aria-describedby="basic-addon1" v-model="banco.type">  
                <input type="text" class="form-control" placeholder="Version" aria-label="Version" aria-describedby="basic-addon1" v-model="banco.version">  
            </div>

            <div class="input-group mb-3">
                <input type="number" class="form-control" placeholder="Port" aria-label="Port" aria-describedby="basic-addon1" v-model="banco.port">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Developer" aria-label="Developer" aria-describedby="basic-addon1" v-model="banco.developer">
                <select class="custom-select mt-2 mr-3" id="inputGroupSelect01" v-model="banco.status">
                    <option selected>0</option>
                    <option value="1">1</option>
                </select>  
                
            </div>

            <div class="d-flex justify-content-center">
                <button type="button" class="btn btn-danger" v-on:click="noneElemento()">Cancel</button>
                <button type="button" class="btn btn-success " v-on:click="createBanco()">Save</button>
                
            </div>
        </div>

        <div class="cont-info conrtainer col-8 mx-auto pt-2">
            <div class=" subtitle d-flex justify-content-center mt-3">
                <h3 >Configuration Server</h3>
            
            </div>
            <div class="info-serve">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1" v-model="servidor.nome">
                    <input type="text" class="form-control" placeholder="IP Address" aria-label="Ip" aria-describedby="basic-addon1" v-model="servidor.ip">
                    
                </div>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Machine" aria-label="Ip" aria-describedby="basic-addon1" v-model="servidor.maquina">
                    <input type="text" class="form-control" placeholder="Processor" aria-label="Ip" aria-describedby="basic-addon1" v-model="servidor.processador">
                </div>
                <div class="input-group mb-3 pb-3 pr-5">
                    <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-primary mt-2 " type="button" id="button-addon2">Alter</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="d-flex flex-row">
            <div class="input-group mb-3 col-4 mx-auto">
                <input type="text" class=" mt-3 form-control" placeholder="Search Banco" v-model="search">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary mt-3" type="button" id="search-serve">Search</button>
                </div>
            </div>
            <div style="width: 100px">
                <button type="button" class="btn-plus btn btn-info w-100 mt-3" v-on:click="blockElemento">+ BD</button>
            </div>
        </div>    
        <table class="table">
            <thead class="thead text-light">
                <tr>
                    <th class="text-center border-right">Name</th>
                    <th class="text-center border-right">Port</th>
                    <th class="text-center border-right">Developer</th>
                    <th class="text-center border-right ">Option</th>
                </tr>
            </thead>
            <tbody class="tbody">
                <tr id="bds" v-for="banco in this.bancoId" :key="banco.name" >
                    <th class="text-center"> {{banco.name}}</th>
                </tr>

                <!-- <tr id="bds" v-for="teste in testes" :key="teste.name">

                    <th class="text-center"> {{teste.name}}</th>
                    <th class="text-center"> {{teste.port}}</th>
                    <th class="text-center"> {{teste.developer}}</th>
                    <th class=" text-center"> <button type="button" class="btn btn-success" id="btn-status" v-on:click="teste()">Info</button>
                     <button type="button" class="btn btn-danger" id="btn-status" v-on:click="teste()">Del</button>
                     </th>
                </tr> -->
            </tbody>
            <tfoot>
                <th>Total</th>
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
    data: function() { 
        return {
            servidor: {
                espaco: this.$store.state.servidor_escolhido.espaco,
                id: this.$store.state.servidor_escolhido.id,
                ip: this.$store.state.servidor_escolhido.ip,
                maquina: this.$store.state.servidor_escolhido.maquina,
                memoria: this.$store.state.servidor_escolhido.memoria,
                nome: this.$store.state.servidor_escolhido.nome,
                processador: this.$store.state.servidor_escolhido.processador,
                status: this.$store.state.servidor_escolhido.status

            },
            banco:{
                name:'',
                type:'',
                version:'',
                port:'',
                developer:'',
                status:'',
                id: 0
            },
            search: '',  
            bancoId:''          
        
        } 

    },
    mounted(){
        this.bancoId = this.getbancobyId()
        console.log('PAGINA: BANCO:')
        console.log( this.$store.state.servidor_escolhido)
    },
    methods:{
        blockElemento(){
  
            document.getElementById('add-bd').style.display = 'block'


        }, 
        noneElemento(){
            document.getElementById('add-bd').style.display = 'none'
         
        },

        teste(){
            document.getElementById('add-bd').style.display = 'block'
            document.getElementById('add-title').innerHTML = 'Alter BD'
        },


        //teste axios

         createBanco () {
         var params = {
            
            'nome': this.banco.name,
            'tipo': this.banco.type,
            'versao': this.banco.version,
            'porta': this.banco.port,
            'desenvolvedor': this.banco.developer,
            'status': this.banco.status,
            'ser_id': 1,
            

        }
            
        if(params.nome === "" || params.tipo === "" || params.versao === '' || params.porta === '' ||
            params.desenvolvedor === '' || params.status === '') return console.log("nunda da pra fazer nada")
        else{
        this.$http.post(`http://localhost:8082/springRest/banco/save`, params)
        .then(response => {
            // JSON responses are automatically parsed.
            // this.response = response.data
            // this.banco.id = response.data
            console.log(response);
            // this.showResponse = true
          }
          ),
        this.noneElemento()
      
        }
         },
        getbancobyId () {
        this.$http.get(`http://localhost:8082/springRest/banco/findByID?id=1` )//+ this.search)
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data
            // console.log(response.data)
            this.response = true
          })

          
      }

    
   
    
}
}
</script>

<style>
    .btn{
        border-radius: none;
    }
    .container-title{
        background-color: #26748E;
        box-shadow: 0 0px 100px 0px #26748E;
    }
    .thead{
        font-family: roboto;
        background: rgb(117, 121, 131);

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
.banco{
    background: #96D3D9;
    height: 100vh;
    width: 100vw;
}
.add-bd{
  display: none;
  margin-top: 5%;
  margin-left: 20%;
  position: absolute;
  height: 62%;
  width: 35%;
  color: #fff;
  background: #26748E;
  z-index: 1000;
}
.bds:hover{
    background: #656769;
    transition: .5s;
}
.add-bd p{
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
    background: #26748E;
     width: 100%;
    color:black ;
}

.cont-info {
    margin-top: 2px;
    background: #D3D2D8;
    box-shadow: 10px 10px 15px 2px #26748E;
    

}


</style>