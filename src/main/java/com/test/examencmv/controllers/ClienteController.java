package com.test.examencmv.controllers;

import com.test.examencmv.models.ClienteCuentaModel;
import com.test.examencmv.models.ClienteModel;
import com.test.examencmv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        return this.clienteService.guardarCliente(cliente);
    }

    @GetMapping( path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") Integer id) {
        return this.clienteService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.clienteService.eliminarCliente(id);
        if (ok){
            return "Se eliminó el cliente con id " + id;
        }else{
            return "No pudo eliminar el cliente con id" + id;
        }
    }

    @GetMapping("/query")
    public ArrayList<ClienteModel> obtenerClientePorCurp(@RequestParam("curp") String curp ){
        return this.clienteService.obtenerPorCurp(curp);
    }
}