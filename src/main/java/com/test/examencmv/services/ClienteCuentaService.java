package com.test.examencmv.services;

import com.test.examencmv.models.ClienteCuentaModel;
import com.test.examencmv.models.ClienteModel;
import com.test.examencmv.models.CuentaModel;
import com.test.examencmv.repositories.ClienteCuentaRepository;
import com.test.examencmv.repositories.ClienteRepository;
import com.test.examencmv.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteCuentaService {
    @Autowired
    ClienteCuentaRepository clienteCuentaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CuentaRepository cuentaRepository;


    public ArrayList<ClienteCuentaModel> obtenerClienteCuentas(){
        return (ArrayList<ClienteCuentaModel>) clienteCuentaRepository.findAll();
    }

    public ClienteCuentaModel guardarClienteCuenta(ClienteCuentaModel clienteCuenta){
        return clienteCuentaRepository.save(clienteCuenta);
    }

    public Optional<ClienteCuentaModel> obtenerPorId(Integer id){
        return clienteCuentaRepository.findById(id);
    }

    public ArrayList<ClienteCuentaModel> obtenerPorIdCliente(Integer idCliente){

        return clienteCuentaRepository.findByClienteId(idCliente);
    }

    public boolean eliminarClienteCuenta(Integer id) {
        try{
            clienteCuentaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }



}
