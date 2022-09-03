/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Cargo;

public interface CargoService {

	// Método para listar
	public List<Cargo> findAll();
}
