package com.example.diagnosticoEddie.service;

import com.example.diagnosticoEddie.model.dto.ClientesDto;
import com.example.diagnosticoEddie.model.entity.ClientesBean;

import java.util.List;

public interface IClientes {

    ClientesBean save (ClientesDto clientesDto);
    ClientesBean findById(Integer id);
    void delete (ClientesBean autoresBean);
    List<ClientesBean> findAll();

    ClientesBean save(ClientesBean existingCliente);
}
