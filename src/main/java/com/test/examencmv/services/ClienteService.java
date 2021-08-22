package com.test.examencmv.services;

import com.test.examencmv.models.ClienteCuentaModel;
import com.test.examencmv.models.ClienteModel;
import com.test.examencmv.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        ArrayList<ClienteModel> clientes = (ArrayList<ClienteModel>) clienteRepository.findAll();

        return clientes;
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> obtenerPorId(Integer id){
        return clienteRepository.findById(id);
    }


    public boolean eliminarCliente(Integer id) {
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<ClienteModel>  obtenerPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    public ArrayList<ClienteModel>  obtenerPorCurp(String curp) {
        return clienteRepository.findByCurp(curp);
    }
}