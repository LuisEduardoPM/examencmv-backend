package com.test.examencmv.services;

import com.test.examencmv.models.CuentaModel;
import com.test.examencmv.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    public ArrayList<CuentaModel> obtenerCuentas(){
        return (ArrayList<CuentaModel>) cuentaRepository.findAll();
    }

    public CuentaModel guardarCuenta(CuentaModel cuenta){
        return cuentaRepository.save(cuenta);
    }

    public Optional<CuentaModel> obtenerPorId(Integer id){
        return cuentaRepository.findById(id);
    }


    public boolean eliminarCuenta(Integer id) {
        try{
            cuentaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<CuentaModel>  obtenerPorNombreCuenta(String nombreCuenta) {
        return cuentaRepository.findByNombreCuenta(nombreCuenta);
    }

}