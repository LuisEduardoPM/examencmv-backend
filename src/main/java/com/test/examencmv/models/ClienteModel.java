package com.test.examencmv.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_cmv_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", length = 255)
    private String nombre;

    @Column(name = "APELLIDO_PATERNO", length = 255)
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO", length = 255)
    private String apellidoMaterno;

    @Column(name = "RFC", length = 20)
    private String rfc;

    @Column(name = "CURP", length = 20)
    private String curp;

    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch=FetchType.LAZY, targetEntity=ClienteCuentaModel.class)
    private List<ClienteCuentaModel> clienteCuenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<ClienteCuentaModel> getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(List<ClienteCuentaModel> clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
    }
}

