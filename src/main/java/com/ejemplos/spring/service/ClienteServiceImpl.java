package com.ejemplos.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.Cliente;

public class ClienteServiceImpl implements ClienteService {

	// Metodo para listar
	public List<Cliente> findAll() {

		RestTemplate restTemplate = new RestTemplate();
		Cliente[] clientes = restTemplate.getForObject("http://localhost:5000/clientes", Cliente[].class);
		List<Cliente> listaClientes = Arrays.asList(clientes);
		return listaClientes;

	}

}
