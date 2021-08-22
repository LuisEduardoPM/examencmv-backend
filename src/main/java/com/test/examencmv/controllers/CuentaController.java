package com.test.examencmv.controllers;

import com.test.examencmv.models.CuentaModel;
import com.test.examencmv.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @GetMapping()
    public ArrayList<CuentaModel> obtenerCuentas(){
        return cuentaService.obtenerCuentas();
    }

    @PostMapping()
    public CuentaModel guardarCuenta(@RequestBody CuentaModel cuenta){
        return this.cuentaService.guardarCuenta(cuenta);
    }

    @GetMapping( path = "/{id}")
    public Optional<CuentaModel> obtenerCuentaPorId(@PathVariable("id") Integer id) {
        return this.cuentaService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.cuentaService.eliminarCuenta(id);
        if (ok){
            return "Se eliminó el cuenta con id " + id;
        }else{
            return "No pudo eliminar el cuenta con id" + id;
        }
    }

    @GetMapping("/query")
    public ArrayList<CuentaModel> obtenerCuentaPorNombreCuenta(@RequestParam("nombreCuenta") String nombreCuenta ){
        return this.cuentaService.obtenerPorNombreCuenta(nombreCuenta);
    }
}
