/*

*@Author NextoMarket

*@Version 1.0

*14/05/2021

*/
package com.ejemplos.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcargo;
	private String cargo;

	public Cargo() {
		super();
	}

	public Cargo(int idcargo, String cargo) {
		super();
		this.idcargo = idcargo;
		this.cargo = cargo;
	}

	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return cargo;
	}

}
