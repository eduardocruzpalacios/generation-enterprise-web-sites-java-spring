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

import generation.enterprise.websites.model.Mensaje;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Override
	public Mensaje create(Mensaje mensaje) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:5000/mensajes/create", mensaje, Mensaje.class);
	}

	@Override
	public List<Mensaje> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Mensaje[] mensajes = restTemplate.getForObject("http://localhost:5000/mensajes", Mensaje[].class);
		return Arrays.asList(mensajes);
	}

}
