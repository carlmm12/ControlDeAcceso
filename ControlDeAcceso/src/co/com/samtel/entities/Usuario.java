package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to CodigoUsuario
	@OneToMany(mappedBy="tblusuario")
	private List<CodigoUsuario> tblcodigoUsuarios;

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

	public List<CodigoUsuario> getTblcodigoUsuarios() {
		return this.tblcodigoUsuarios;
	}

	public void setTblcodigoUsuarios(List<CodigoUsuario> tblcodigoUsuarios) {
		this.tblcodigoUsuarios = tblcodigoUsuarios;
	}

	public CodigoUsuario addTblcodigoUsuario(CodigoUsuario tblcodigoUsuario) {
		getTblcodigoUsuarios().add(tblcodigoUsuario);
		tblcodigoUsuario.setTblusuario(this);

		return tblcodigoUsuario;
	}

	public CodigoUsuario removeTblcodigoUsuario(CodigoUsuario tblcodigoUsuario) {
		getTblcodigoUsuarios().remove(tblcodigoUsuario);
		tblcodigoUsuario.setTblusuario(null);

		return tblcodigoUsuario;
	}

}