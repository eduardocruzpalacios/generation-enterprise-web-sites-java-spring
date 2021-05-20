/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Proyecto;

public interface ProyectoService {

	// Metodo para listar
	public List<Proyecto> findAll();

	// Método para guardar
	public Proyecto saveAdd(Proyecto proyecto);

	// Método para borrar
	public void deleteById(int idproyecto);

	// Método para modificar
	public void saveUpdate(Proyecto proyecto);
}
