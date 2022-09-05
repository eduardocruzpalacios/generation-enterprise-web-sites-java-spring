/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package generation.enterprise.websites.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import generation.enterprise.websites.model.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Override
	public Proyecto create(Proyecto proyecto) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:5000/proyectos/create", proyecto, Proyecto.class);
	}

	@Override
	public List<Proyecto> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
		return Arrays.asList(proyectos);
	}

	@Override
	public Proyecto findById(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos/" + id, Proyecto[].class);
		return proyectos[0];
	}

	@Override
	public List<Proyecto> findByCliente(int idcliente) {
		RestTemplate restTemplate = new RestTemplate();
		Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos/cliente/" + idcliente,
				Proyecto[].class);
		return Arrays.asList(proyectos);
	}

	@Override
	public void update(Proyecto proyecto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:5000/proyectos/" + proyecto.getIdproyecto() + "/update", proyecto,
				Proyecto.class);
	}

	@Override
	public void delete(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:5000/proyectos/" + id + "/delete");
	}

}
