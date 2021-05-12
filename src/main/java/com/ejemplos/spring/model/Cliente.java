/*
 * class Cliente
 * 11/05/2021
 * v 1.0
 * @Miguel
 */

package com.ejemplos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	private int idcliente;

	// @Column
	private String nombre;

	// @Column
	private String description;

	// @Column
	private String logo;

	public Cliente() {
		super();
	}

	public Cliente(int idcliente, String nombre, String description, String logo) {
		super();
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
