/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.Cargo;

@Service
public class CargoServiceImpl implements CargoService {

	// Metodo para listar
	public List<Cargo> findAll() {

		RestTemplate restTemplate = new RestTemplate();
		Cargo[] cargos = restTemplate.getForObject("http://localhost:5000/cargos", Cargo[].class);
		List<Cargo> listaCargos = Arrays.asList(cargos);
		return listaCargos;

	}
}
