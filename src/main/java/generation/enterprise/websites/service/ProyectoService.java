/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package generation.enterprise.websites.service;

import java.util.List;

import generation.enterprise.websites.model.Proyecto;

public interface ProyectoService {

	public Proyecto create(Proyecto proyecto);

	public List<Proyecto> findAll();

	public Proyecto findById(int id);

	public void update(Proyecto proyecto);

	public void delete(int id);

}
