/*

*@Author NextoMarket

*@Version 1.0

*14/05/2021

*/
package generation.enterprise.websites.model;

public class Cargo {

	private int idcargo;
	private String cargo;

	public Cargo() {
	}

	public Cargo(int idcargo, String cargo) {
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
		return "Cargo [idcargo=" + idcargo + ", cargo=" + cargo + "]";
	}

}
