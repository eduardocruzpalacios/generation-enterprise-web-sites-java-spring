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

import generation.enterprise.websites.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Override
	public Persona create(Persona persona) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:5000/personas/create", persona, Persona.class);
	}

	@Override
	public List<Persona> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Persona[] personas = restTemplate.getForObject("http://localhost:5000/personas", Persona[].class);
		return Arrays.asList(personas);
	}

	@Override
	public Persona findById(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Persona[] personas = restTemplate.getForObject("http://localhost:5000/personas/" + id, Persona[].class);
		return personas[0];
	}

	@Override
	public void update(Persona persona) {
		RestTemplate restTemplateUpdate = new RestTemplate();
		restTemplateUpdate.put("http://localhost:5000/personas/" + persona.getIdpersona() + "/update", persona,
				Persona.class);
	}

	@Override
	public void delete(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:5000/personas/" + id + "/delete");
	}

}
