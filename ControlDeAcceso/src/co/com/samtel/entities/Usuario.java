package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblusuarios database table.
 * 
 */
@Entity
@Table(name="tblusuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cedula;

	private int estado;

	private String nombre;

	public Usuario() {
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", estado=" + estado + ", nombre=" + nombre + "]";
	}
	

}