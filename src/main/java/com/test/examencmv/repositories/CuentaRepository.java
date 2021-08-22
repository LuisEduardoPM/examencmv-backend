package com.test.examencmv.repositories;

import com.test.examencmv.models.ClienteModel;
import com.test.examencmv.models.CuentaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CuentaRepository extends CrudRepository<CuentaModel, Integer> {
    ArrayList<CuentaModel> findByNombreCuenta(String nombreCuenta);
}
