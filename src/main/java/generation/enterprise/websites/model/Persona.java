/*

*@Author NextoMarket

*@Version 1.0

*14/05/2021

*/

package generation.enterprise.websites.model;

public class Persona {

	private int idpersona;
	private String nombre;
	private String apellidos;
	private String resumen;
	private String foto;
	private Cargo cargo;

	public Persona() {
	}

	public Persona(int idpersona, String nombre, String apellidos, String resumen, String foto, Cargo cargo) {
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.resumen = resumen;
		this.foto = foto;
		this.cargo = cargo;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", resumen="
				+ resumen + ", foto=" + foto + ", cargo=" + cargo + "]";
	}

}
