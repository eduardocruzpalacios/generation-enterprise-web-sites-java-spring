/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package generation.enterprise.websites.service;

import java.util.List;

import generation.enterprise.websites.model.Mensaje;

public interface MensajeService {

	public Mensaje create(Mensaje mensaje);

	public List<Mensaje> findAll();

}
