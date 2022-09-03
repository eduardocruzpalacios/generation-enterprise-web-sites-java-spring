package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.ejemplos.spring.service.PersonaServiceImpl;

@SpringBootTest
public class Test_saveAdd_PersonaServiceImpl {

	
	
	@Autowired
	private PersonaServiceImpl personaService;
	
	@Test
	void guardaUnUsuario() {
		assertThat(personaService).isNotNull();
	}
}
