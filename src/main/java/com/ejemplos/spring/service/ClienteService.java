package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Cliente;

public interface ClienteService {

	// Metodo para listar
	public List<Cliente> findAll();

}
