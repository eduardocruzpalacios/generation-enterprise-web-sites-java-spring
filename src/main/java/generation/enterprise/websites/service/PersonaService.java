/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package generation.enterprise.websites.service;

import java.util.List;

import generation.enterprise.websites.model.Persona;

public interface PersonaService {

	public Persona create(Persona persona);

	public List<Persona> findAll();

	public Persona findById(int id);

	public void update(Persona persona);

	public void delete(int id);

}
