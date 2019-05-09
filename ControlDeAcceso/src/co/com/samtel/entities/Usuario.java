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
	private int id;

	private int estado;

	private String nombre;

	//bi-directional many-to-one association to ControlAccesosOrd
	@OneToMany(mappedBy="tblusuario")
	private List<ControlAccesosOrd> tblcontrolAccesosOrds;

	//bi-directional many-to-one association to ControlDiario
	@OneToMany(mappedBy="tblusuario")
	private List<ControlDiario> tblcontrolDiarios;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<ControlAccesosOrd> getTblcontrolAccesosOrds() {
		return this.tblcontrolAccesosOrds;
	}

	public void setTblcontrolAccesosOrds(List<ControlAccesosOrd> tblcontrolAccesosOrds) {
		this.tblcontrolAccesosOrds = tblcontrolAccesosOrds;
	}

	public ControlAccesosOrd addTblcontrolAccesosOrd(ControlAccesosOrd tblcontrolAccesosOrd) {
		getTblcontrolAccesosOrds().add(tblcontrolAccesosOrd);
		tblcontrolAccesosOrd.setTblusuario(this);

		return tblcontrolAccesosOrd;
	}

	public ControlAccesosOrd removeTblcontrolAccesosOrd(ControlAccesosOrd tblcontrolAccesosOrd) {
		getTblcontrolAccesosOrds().remove(tblcontrolAccesosOrd);
		tblcontrolAccesosOrd.setTblusuario(null);

		return tblcontrolAccesosOrd;
	}

	public List<ControlDiario> getTblcontrolDiarios() {
		return this.tblcontrolDiarios;
	}

	public void setTblcontrolDiarios(List<ControlDiario> tblcontrolDiarios) {
		this.tblcontrolDiarios = tblcontrolDiarios;
	}

	public ControlDiario addTblcontrolDiario(ControlDiario tblcontrolDiario) {
		getTblcontrolDiarios().add(tblcontrolDiario);
		tblcontrolDiario.setTblusuario(this);

		return tblcontrolDiario;
	}

	public ControlDiario removeTblcontrolDiario(ControlDiario tblcontrolDiario) {
		getTblcontrolDiarios().remove(tblcontrolDiario);
		tblcontrolDiario.setTblusuario(null);

		return tblcontrolDiario;
	}

}