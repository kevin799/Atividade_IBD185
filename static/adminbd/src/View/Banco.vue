<template>
  <div class="home">
    <div class="title">
      <div class="container-fluid mt-1 bg-dark p-3 d-flex justify-content-between ">
        <div></div>
        <h1 class="mt-1">Database</h1>
        <div>
             
        </div>
      </div>
    </div>
  

    <div class="container"> 
        <div class="add-bd" id="add-bd">
            <h1 class="title" id='add-title'><p>Adicionar</p></h1>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="IP Address" aria-label="Ip" aria-describedby="basic-addon1">
                <select class="custom-select mt-2 mr-3" id="inputGroupSelect01">
                    <option selected>Machine</option>
                    <option value="1">AWS</option>
                    <option value="2">Digital Ocean</option>
                    <option value="3">Red Hat</option>
                </select>  
            </div>

            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Processor" aria-label="Processor" aria-describedby="basic-addon1">
            </div>
      
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Memory" aria-label="Memory" aria-describedby="basic-addon1">
                <input type="text" class="form-control" placeholder="Space" aria-label="Space" aria-describedby="basic-addon1">
            </div>

            <div class="d-flex justify-content-center">
                <button type="button" class="btn btn-success btn-lg" v-on:click="noneElemento">Save</button>
            </div>
        </div>

        <div class="cont-info conrtainer col-8 mx-auto">
            <div class="title subtitle d-flex justify-content-center mt-3">
                <h3 >Configuration Server</h3>
            
            </div>
            <div class="info-serve">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1">
                    <input type="text" class="form-control" placeholder="IP Address" aria-label="Ip" aria-describedby="basic-addon1">
                    
                </div>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Machine" aria-label="Ip" aria-describedby="basic-addon1">
                    <input type="text" class="form-control" placeholder="Processor" aria-label="Ip" aria-describedby="basic-addon1">
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
                <input type="text" class=" mt-3 form-control" placeholder="Search Server">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary mt-3" type="button" id="search-serve">Search</button>
                </div>
            </div>
            <div style="width: 100px">
                <button type="button" class="btn-plus btn btn-info w-100 mt-3" v-on:click="blockElemento">+ BD</button>
            </div>
        </div>    
        <table class="table">
            <thead class="thead bg-dark text-light">
                <tr>
                    <th class="text-center border-right">Name</th>
                    <th class="text-center border-right">Port</th>
                    <th class="text-center border-right">IP</th>
                    <th class="text-center border-right ">Option</th>
                </tr>
            </thead>
            <tbody class="tbody">
                <tr id="bds">
                    <th class="text-center"> sla</th>
                    <th class="text-center"> 8081</th>
                    <th class="text-center"> 192.168.1.2</th>
                    <th class=" text-center"> <button type="button" class="btn btn-success" id="btn-status" v-on:click="teste()">Info</button>
                     <button type="button" class="btn btn-danger" id="btn-status" v-on:click="teste()">Del</button>
                     </th>
                </tr>
            </tbody>
            <tfoot>
                <th>Total</th>
            </tfoot>
        </table>
    </div>

  </div>
</template>


<script>
export default {

    mounted(){
        this.habiServiButton()
        this.openInfoServ()
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
            const text = document.getElementById('add-title').innerHTML = 'Alter BD'
        }
    }


    
   
    
}
</script>

<style>
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
.add-bd{
  display: none;
  margin-top: 16px;
  margin-left: 20%;
  position: absolute;
  height: 62%;
  width: 35%;
  color: #fff;
  background: #8a8e92;
  z-index: 1000;
}
.bds:hover{
    background: #656769;;
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
    background: #8a8e92;
     width: 100%;
    color:white;
}

.cont-info {
    background: #8a8e92;
}


</style>
