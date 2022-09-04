/*
 * class Cliente
 * 11/05/2021
 * v 1.0
 * @Miguel
 */

package generation.enterprise.websites.model;

public class Cliente {

	private int idcliente;
	private String nombre;
	private String description;
	private String logo;

	public Cliente() {
	}

	public Cliente(int idcliente, String nombre, String description, String logo) {
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.description = description;
		this.logo = logo;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nombre=" + nombre + ", description=" + description + ", logo="
				+ logo + "]";
	}

}
