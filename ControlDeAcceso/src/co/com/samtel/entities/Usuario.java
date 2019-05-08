package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_usuarios database table.
 * 
 */
@Entity
@Table(name="tbl_usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuarios")
	private int idUsuarios;

	private String estado;

	@Column(name="nombre_completo")
	private String nombreCompleto;

	public Usuario() {
	}

	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuarios=" + idUsuarios + ", estado=" + estado + ", nombreCompleto=" + nombreCompleto + "]";
	}
	
	

}