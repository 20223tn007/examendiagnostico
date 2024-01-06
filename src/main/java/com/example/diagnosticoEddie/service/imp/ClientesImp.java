package com.example.diagnosticoEddie.service.imp;

import com.example.diagnosticoEddie.model.dao.ClientesDao;
import com.example.diagnosticoEddie.model.dto.ClientesDto;
import com.example.diagnosticoEddie.model.entity.ClientesBean;
import com.example.diagnosticoEddie.service.IClientes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientesImp implements IClientes {

    private final ClientesDao clientesDao;

    @Override
    @Transactional
    public ClientesBean save(ClientesDto clientesDto) {
        ClientesBean clientes = ClientesBean.builder()
                .apellido(clientesDto.getApellido())
                .curp(clientesDto.getCurp())
                .nombre(clientesDto.getNombre())
                .build();
        return clientesDao.save(clientes);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientesBean findById(Integer id) {
        return clientesDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(ClientesBean clientesBean) {
        clientesDao.delete(clientesBean);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientesBean> findAll() {
        return (List<ClientesBean>) clientesDao.findAll();
    }

    @Override
    public ClientesBean save(ClientesBean existingCliente) {
        return null;
    }
}
