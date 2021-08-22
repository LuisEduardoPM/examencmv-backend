package com.test.examencmv.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_cmv_cliente_cuenta")
public class ClienteCuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE_CUENTA", unique = true, nullable = false)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= ClienteModel.class, optional = true)
    @JoinColumn(name = "ID_CLIENTE", nullable = true)
    private ClienteModel cliente;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= CuentaModel.class)
    @JoinColumn(name = "ID_CUENTA", nullable = true)
    private CuentaModel cuenta;

    @Column(name = "SALDO_ACTUAL", precision = 18, scale = 8)
    private BigDecimal saldoActual;

    @Column(name = "FECHA_CONTRATACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaContratacion;

    @Column(name = "FECHA_ULTIMO_MOVIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoMovimiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
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

    public CuentaModel getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModel cuenta) {
        this.cuenta = cuenta;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
