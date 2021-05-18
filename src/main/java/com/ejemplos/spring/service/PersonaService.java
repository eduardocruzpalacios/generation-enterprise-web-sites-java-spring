/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Persona;

public interface PersonaService {

	//Método para listar
	public List<Persona> findAll();
	
	//Método para guardar
	public Persona save(Persona persona);
	
	// Método para borrar
		public void deleteById(int idpersona);
}
