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
        <div class="d-flex flex-row">
            <div class="input-group mb-3 col-4 mx-auto">
                <input type="text" class=" mt-3 form-control" placeholder="Search Server">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary mt-3" type="button" id="search-serve">Search</button>
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
                    <th class="text-center border-right">Port</th>
                    <th class="text-center border-right">IP</th>
                    <th class="text-center border-right ">Status</th>
                </tr>
            </thead>
            <tbody class="tbody">
            
                <tr>
                    <th class="text-center"> teste</th>
                    <th class="text-center"> teste</th>
                    <th class="text-center"> teste</th>
                    <th class=" text-center"> <button type="button" class="btn btn-outline-info" >Info</button></th>
                </tr>
            </tbody>
            <tfoot>
                <th>Total</th>
            </tfoot>
        </table>
    </div>
  </div>
</template>


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
  
</style>
