 package com.atos.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.springboot.backend.apirest.models.dao.IClienteDao;
import com.atos.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired								// Inyecta la implementación de la interfaz clienteDao
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)			// Marca que la transacción es de solo lectura (es un select)
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteDao.findAll();

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
