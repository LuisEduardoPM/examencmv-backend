package com.test.examencmv.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.examencmv.models.ClienteCuentaModel;
import com.test.examencmv.models.ClienteModel;
import com.test.examencmv.models.CuentaModel;
import com.test.examencmv.repositories.ClienteRepository;
import com.test.examencmv.repositories.CuentaRepository;
import com.test.examencmv.services.ClienteCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientecuenta")
public class ClienteCuentaController {
    @Autowired
    ClienteCuentaService clienteCuentaService;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping()
    public ArrayList<ClienteCuentaModel> obtenerClienteCuentas(){
        return clienteCuentaService.obtenerClienteCuentas();
    }

    @PostMapping()
    public ClienteCuentaModel guardarClienteCuenta(@RequestBody ClienteCuenta clienteCuenta){
        ClienteCuentaModel cc = new ClienteCuentaModel();
        cc.setSaldoActual(clienteCuenta.getSaldoActual());
        cc.setFechaContratacion(clienteCuenta.getFechaContratacion());
        cc.setFechaUltimoMovimiento(clienteCuenta.getFechaUltimoMovimiento());
        if (clienteCuenta.getIdCliente() != null){
            cc.setCliente(clienteRepository.findById(clienteCuenta.getIdCliente()).get());
        }
        if (clienteCuenta.getIdCuenta() != null){
            cc.setCuenta(cuentaRepository.findById(clienteCuenta.getIdCuenta()).get());
        }
        return this.clienteCuentaService.guardarClienteCuenta(cc);
    }

    @GetMapping( path = "/{id}")
    public Optional<ClienteCuentaModel> obtenerClienteCuentaPorId(@PathVariable("id") Integer id) {
        return this.clienteCuentaService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.clienteCuentaService.eliminarClienteCuenta(id);
        if (ok){
            return "Se eliminó el clienteCuenta con id " + id;
        }else{
            return "No pudo eliminar el clienteCuenta con id" + id;
        }
    }

    @GetMapping( path = "cliente/{id}")
    public ArrayList<ClienteCuentaModel> obtenerClienteCuentaPorIdCliente(@PathVariable("id") Integer idCliente) {
        return this.clienteCuentaService.obtenerPorIdCliente(idCliente);
    }



}

class ClienteCuenta{
    private BigDecimal saldoActual;
    private Integer idCliente;
    private Integer idCuenta;
    private Date fechaContratacion;
    private Date fechaUltimoMovimiento;

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Date getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public void setFechaUltimoMovimiento(Date fechaUltimoMovimiento) {
        this.fechaUltimoMovimiento = fechaUltimoMovimiento;
    }
}
