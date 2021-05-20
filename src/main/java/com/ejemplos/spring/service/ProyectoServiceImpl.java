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

import com.ejemplos.spring.model.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	// Metodo para listar
	public List<Proyecto> findAll() {

		RestTemplate restTemplate = new RestTemplate();
		Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/listarproyectos", Proyecto[].class);
		List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		return listaProyectos;

	}

	// Método para guardar
	public Proyecto saveAdd(Proyecto proyecto) {

		RestTemplate restTemplateSave = new RestTemplate();
		Proyecto pSave = restTemplateSave.postForObject("http://localhost:5000/addproyecto", proyecto, Proyecto.class);
		return pSave;
	}

	// Método para eliminar
	@Override
	public void deleteById(int idproyecto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:5000/eliminarproyecto/" + idproyecto);
	}
	
	//Método para localizar
	public Proyecto findById(int idproyecto) {
		RestTemplate restTemplate = new RestTemplate();
		 Proyecto[] p = restTemplate.getForObject("http://localhost:5000/localizarproyecto/" + idproyecto, Proyecto[].class);
		 return p[0];
	}

	// Método para modificar
	public void updateProyecto(Proyecto proyecto) {
		RestTemplate restTemplateUpdate = new RestTemplate();
		restTemplateUpdate.put("http://localhost:5000/updateproyecto/" + proyecto, Proyecto.class);
	}

}
