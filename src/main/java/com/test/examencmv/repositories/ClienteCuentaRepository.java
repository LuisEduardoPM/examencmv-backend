package com.test.examencmv.repositories;

import com.test.examencmv.models.ClienteCuentaModel;
import com.test.examencmv.models.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ClienteCuentaRepository extends CrudRepository<ClienteCuentaModel, Integer> {
    ArrayList<ClienteCuentaModel> findByClienteId(Integer id);
}
