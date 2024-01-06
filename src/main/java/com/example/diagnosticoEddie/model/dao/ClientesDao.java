package com.example.diagnosticoEddie.model.dao;

import com.example.diagnosticoEddie.model.entity.ClientesBean;
import org.springframework.data.repository.CrudRepository;

public interface ClientesDao extends CrudRepository<ClientesBean, Integer> {

}
