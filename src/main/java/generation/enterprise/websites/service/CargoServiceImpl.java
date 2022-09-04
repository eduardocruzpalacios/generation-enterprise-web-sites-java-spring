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

import generation.enterprise.websites.model.Cargo;

@Service
public class CargoServiceImpl implements CargoService {

	@Override
	public List<Cargo> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Cargo[] cargos = restTemplate.getForObject("http://localhost:5000/cargos", Cargo[].class);
		return Arrays.asList(cargos);
	}

}
