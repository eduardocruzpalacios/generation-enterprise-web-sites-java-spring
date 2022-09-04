/*

*Fecha: 30/08/2022

*@Author NextoMarket

*@Version 1.0

*/

package generation.enterprise.websites.model;

import java.sql.Timestamp;

public class Mensaje {

	private int idmensaje;
	private String from;
	private Timestamp fecha;
	private String subject;
	private String mensaje;
	private String respuesta;

	public Mensaje() {
	}

	public Mensaje(int idmensaje, String from, Timestamp fecha, String subject, String mensaje, String respuesta) {
		this.idmensaje = idmensaje;
		this.from = from;
		this.fecha = fecha;
		this.subject = subject;
		this.mensaje = mensaje;
		this.respuesta = respuesta;
	}

	public int getIdmensaje() {
		return idmensaje;
	}

	public void setIdmensaje(int idmensaje) {
		this.idmensaje = idmensaje;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Mensaje [idmensaje=" + idmensaje + ", from=" + from + ", fecha=" + fecha + ", subject=" + subject
				+ ", mensaje=" + mensaje + ", respuesta=" + respuesta + "]";
	}

}
