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

import generation.enterprise.websites.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Override
	public List<Cliente> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		Cliente[] clientes = restTemplate.getForObject("http://localhost:5000/clientes", Cliente[].class);
		return Arrays.asList(clientes);
	}

}
