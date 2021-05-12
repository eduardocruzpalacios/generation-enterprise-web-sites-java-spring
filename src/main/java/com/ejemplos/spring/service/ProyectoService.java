/*
 * @Author Maria y Andrei
 * @Version 1.0
 */

package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Proyecto;

public interface ProyectoService {
	
	//Metodo para listar
	public List<Proyecto> findAll();
	
}
