package generation.enterprise.websites.service;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import generation.enterprise.websites.model.Cargo;
import generation.enterprise.websites.model.Persona;

public class PersonaFakeService {

	public static List<Persona> createPersonas(int number) {
		List<Persona> fakePersonas = new ArrayList<Persona>();
		for (int i = 0; i < number; i++) {
			Persona persona = createPersona();
			fakePersonas.add(persona);
		}
		return fakePersonas;
	}

	private static Persona createPersona() {
		Faker faker = new Faker();
		String nombre = faker.name().firstName();
		String apellidos = faker.name().lastName();
		String resumen = faker.demographic().educationalAttainment();
		String title = faker.name().title();
		String foto = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/User_font_awesome.svg/2048px-User_font_awesome.svg.png";
		Cargo cargo = new Cargo();
		cargo.setCargo(title);
		Persona persona = new Persona(0, nombre, apellidos, resumen, foto, cargo);
		return persona;
	}

}
