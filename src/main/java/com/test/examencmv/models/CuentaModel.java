package com.test.examencmv.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cat_cmv_tipo_cuenta")
public class CuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUENTA", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_CUENTA", length = 255)
    private String nombreCuenta;

    @JsonIgnore
    @OneToMany(mappedBy = "cuenta", fetch=FetchType.LAZY, targetEntity=ClienteCuentaModel.class)
    private List<ClienteCuentaModel> clienteCuenta;

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
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
