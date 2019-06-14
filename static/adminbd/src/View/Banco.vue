
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

        <!-- Inicio - Adicinar Banco -->
        <div class="add-bd border border-dark" id="add-bd">
            <h1 class="title" id='add-title'><p>Adicionar Banco</p></h1>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Nome" aria-label="Name" aria-describedby="basic-addon1" v-model="banco.nome">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Tipo" aria-label="Type" aria-describedby="basic-addon1" v-model="banco.tipo">  
                <input type="text" class="form-control" placeholder="Versao" aria-label="Version" aria-describedby="basic-addon1" v-model="banco.versao">  
            </div>

            <div class="input-group mb-3">
                <input type="number" class="form-control" placeholder="Porta" aria-label="Port" aria-describedby="basic-addon1" v-model="banco.porta">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Desenvolvedor" aria-label="Developer" aria-describedby="basic-addon1" v-model="banco.desenvolvedor">
                <select class="custom-select mt-2 mr-3" id="inputGroupSelect01" v-model="banco.status">
                    <option selected>0</option>
                    <option value="1">1</option>
                </select>  
                
            </div>

            <div class="d-flex justify-content-center">
                <button type="button" class="btn btn-danger" v-on:click="noneElemento()">Cancelar</button>
                <button type="button" class="btn btn-success " v-on:click="createBanco()">Salvar</button>
                
            </div>
        </div>
        <!-- Fim - Adicinar Banco -->

        <!-- Inicio - Alterar Banco -->
        <div class="add-bd border border-dark" id="edit-bd">
            <h1 class="title" id='add-title'><p>Informações do Banco</p></h1>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Nome" aria-label="Name" aria-describedby="basic-addon1" v-model="banco.nome" disabled>
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Tipo" aria-label="Type" aria-describedby="basic-addon1" v-model="banco.tipo" disabled>  
                <input type="text" class="form-control" placeholder="Versao" aria-label="Version" aria-describedby="basic-addon1" v-model="banco.versao" disabled>  
            </div>

            <div class="input-group mb-3">
                <input type="number" class="form-control" placeholder="Porta" aria-label="Port" aria-describedby="basic-addon1" v-model="banco.porta" disabled>
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Desenvolvedor" aria-label="Developer" aria-describedby="basic-addon1" v-model="banco.desenvolvedor" disabled>
                <select class="custom-select mt-2 mr-3" id="inputGroupSelect01" v-model="banco.status" disabled>
                    <option selected>0</option>
                    <option value="1">1</option>
                </select>  
                
            </div>

            <div class="d-flex justify-content-center">
                <button type="button" class="btn btn-success" v-on:click="noneElemento()">Ok</button>
                <!-- <button type="button" class="btn btn-success " v-on:click="editBanco(banco)">Save</button> -->
                
            </div>
        </div>

        <!-- Fim - Alterar Banco -->

        <div class="cont-info conrtainer col-8 mx-auto pt-2">
            <div class=" subtitle d-flex justify-content-center mt-3">
                <h3 >Configuration Server</h3>
            
            </div>
            <div class="info-serve">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1" v-model="servidor.nome">
                    <input type="text" class="form-control" placeholder="IP Address" aria-label="Ip" aria-describedby="basic-addon1" v-model="servidor.ip" disabled>
                    
                </div>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Machine" aria-label="Machine" aria-describedby="basic-addon1" v-model="servidor.maquina">
                    <input type="text" class="form-control" placeholder="Processor" aria-label="Processador" aria-describedby="basic-addon1" v-model="servidor.processador">
                </div>
                <div class="input-group mb-3 pb-3 pr-5">
                    <input type="text" class="form-control" placeholder="Memory" aria-label="Memoria" aria-describedby="button-addon2" v-model="servidor.memoria">
                    <input type="text" class="form-control" placeholder="Espaco" aria-label="Espaco" aria-describedby="button-addon2" v-model="servidor.espaco">
                    <div class="input-group-append">
                        <button class="btn btn-primary mt-2 " type="button" id="button-addon2" v-on:click="updateServidor(servidor)">Aplicar Alterações</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="d-flex flex-row">
            <div class="input-group mb-3 col-4 mx-auto">
                <input type="text" class=" mt-3 form-control" placeholder="Procurar Banco por NOME" v-model="search">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary mt-3" type="button" id="search-serve" v-on:click="searchBanco">Search</button>
                </div>
            </div>
            <div style="width: 100px">
                <button type="button" class="btn-plus btn btn-info w-100 mt-3" v-on:click="blockElemento">+ BD</button>
            </div>
        </div>    
        <table class="table">
            <thead class="thead text-light">
                <tr>
                    <th class="text-center border-right">ID</th>
                    <th class="text-center border-right">Nome</th>
                    <th class="text-center border-right">Porta</th>
                    <th class="text-center border-right">Desenvolvedor</th>
                    <th class="text-center border-right ">Opção</th>
                </tr>
            </thead>
            <tbody class="tbody">
                <!-- <tr id="bds" v-for="banco in this.bancos" :key="banco.name" >
                    <th class="text-center"> {{banco.name}}</th>
                </tr> -->

                 <tr id="bds" v-for="banco in this.Bancos">
                    <th class="text-center"> {{banco.id}}</th>
                    <th class="text-center"> {{banco.nome}}</th>
                    <th class="text-center"> {{banco.porta}}</th>
                    <th class="text-center"> {{banco.desenvolvedor}}</th>
                    <!-- <th class="text-center"> {{banco.tipo}}</th>
                    <th class="text-center"> {{banco.versao}}</th> -->
                    <th class=" text-center"> <button type="button" class="btn btn-success" id="btn-status" v-on:click="editBanco(banco)">Informações</button>
                     <button type="button" class="btn btn-danger" id="btn-status" v-on:click="deleteBanco(banco)">Deletar</button>
                     </th>
                </tr> 
            </tbody>
            <!-- <tfoot>
                <th>Total</th>
            </tfoot> -->
        </table>
    </div>

  </div>
</template>


<script>

//Importando o store 
import { store } from '../store/store'
import axios from 'axios'

export default {
    component: {
        //adicionando o store para usar dentro do componente
        store
    },
    data: function() { 
        return {
            Bancos:[],
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
                nome:'',
                tipo:'',
                versao:'',
                porta:'',
                desenvolvedor:'',
                status:'',
                id: 0
            },

            search: '',          
        
        } 

    },
    mounted(){
        this.getAllBancos()
        console.log(this.$store.state.servidor_escolhido.id)
        // console.log(this.espaco)
        // this.bancoId = this.getbancobyId()
        // console.log(this.servidor.ip)
        // Pra acessar a variavel do Store precisa usar this.$store.state
        // console.log( this.$store.state.servidor_escolhido)
    },
    methods:{

        searchBanco(){
            if(this.search ===''){
                this.getAllBancos();

            }
            else{
            console.log(this.search)
            axios.post(`/banco/findByName?name=${this.search}`)
            .then(response => {
                this.Bancos = response.data
            }).catch(error => console.log(error))
            }
        },
        updateServidor(servidor){

            if (confirm("Você realmente deseja enviar as alterações?")){

                axios.post(`/servidorPrincipal/atualizaServidorP?ip=${servidor.ip}&nome=${servidor.nome}&maquina=${servidor.maquina}&processador=${servidor.processador}&memoria=${servidor.memoria}&espaco=${servidor.espaco}`)
                .then(response => {
                    // JSON responses are automatically parsed.
                    // this.response = response.data
                    // this.banco.id = response.data
                    alert("Servidor Atualizado!")
                    console.log(response);

                    // this.showResponse = true
                }).catch(error => console.log(error))
            }
        },
        blockElemento(){
  
            document.getElementById('add-bd').style.display = 'block'


        }, 
        noneElemento(){
            document.getElementById('add-bd').style.display = 'none'
            document.getElementById('edit-bd').style.display = 'none'
         
        },

        editBanco(banco){
            //Essa função serve somente para popular os campos da tela
            // por conta de como foi desenvolvido o front
            this.banco = banco;
            document.getElementById('edit-bd').style.display = 'block'

        },

        deleteBanco(banco){

            console.log(`banco ${banco} deletado com sucesso! \n\nMentira, é só um console.log`)

        },


        //teste axios

        createBanco () {
            var params = {
                
                'nome': this.banco.nome,
                'tipo': this.banco.tipo,
                'versao': this.banco.versao,
                'porta': this.banco.porta,
                'desenvolvedor': this.banco.desenvolvedor,
                'servidor': this.servidor,
                'status': this.banco.status,

            }
                
            if(params.nome === '' || params.tipo === '' || params.versao === '' || params.porta === '' ||
                params.desenvolvedor === '' || params.status === '') return alert("Erro ao cadastrar Banco - Verifique todos os campos!")
            
            else{
                // console.log("Vendo parametros")
                delete params.servidor.id
                // console.log(params)
                axios.post(`/banco/save`, params)
                .then(response => {
                    // JSON responses are automatically parsed.
                    // this.response = response.data
                    // this.banco.id = response.data
                    console.log(response);
                    // this.showResponse = true
                //     this.Bancos.push(params)
                // console.log(this.Bancos)
                
                this.noneElemento()
                this.getAllBancos()
                alert("Banco Cadastrado com sucesso!")
                }).catch(error => console.log(error))

                // console.log('Realizando Alterações Banco')
                

            }
        },

    //     getbancobyId () {
    //     axios.get(`/banco/findByID?id=1` )//+ this.search)
    //       .then(response => {
    //         // JSON responses are automatically parsed.
    //         this.response = response.data
    //         // console.log(response.data)
    //         this.response = true
    //       })
    //   },
      getAllBancos(){
          
            axios.get(`/banco/getAll?ip=${this.servidor.ip}`)
            .then(res =>{
                console.log("Lista de Bancos presentes neste servidor")
                console.log(res.data)
                this.Bancos = res.data;
            })
        },
        deleteBanco(banco){
            axios.get(`/banco/delete?id=${banco.id}`)
            .then(response => {

                console.log(response);
                console.log("Banco dedetado!")
            this.getAllBancos();

            }).catch(error => console.log(error))
        }

    
   
    
}
}
</script>

<style>
    .btn{
        border-radius: none;
    }
    .container-title{
        background-color: rgb(255, 255, 255);
        /* box-shadow: 0 0px 100px 0px #26748E; */
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
  font-family: 'OpenSans', sans-serif;
  
}
.banco{
    background: rgb(255, 255, 255);
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
    box-shadow: 10px 10px 15px 2px rgb(151, 178, 187);
    

}


</style>