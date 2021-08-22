package com.test.examencmv.repositories;
import java.util.ArrayList;


import com.test.examencmv.models.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Integer> {

    ArrayList<ClienteModel> findByNombre(String nombre);

    ArrayList<ClienteModel> findByCurp(String curp);

}