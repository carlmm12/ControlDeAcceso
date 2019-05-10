package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the tblcodigo_usuarios database table.
 * 
 */
@Entity
@Table(name="tblcodigo_usuarios")
@NamedQuery(name="CodigoUsuario.findAll", query="SELECT c FROM CodigoUsuario c")
public class CodigoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;

	private BigInteger cedula;

	//bi-directional many-to-one association to ControlAccesosOrd
	@OneToMany(mappedBy="tblcodigoUsuario")
	private List<ControlAccesosOrd> tblcontrolAccesosOrds;

	//bi-directional many-to-one association to ControlDiario
	@OneToMany(mappedBy="tblcodigoUsuario")
	private List<ControlDiario> tblcontrolDiarios;

	public CodigoUsuario() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public BigInteger getCedula() {
		return this.cedula;
	}

	public void setCedula(BigInteger cedula) {
		this.cedula = cedula;
	}

	public List<ControlAccesosOrd> getTblcontrolAccesosOrds() {
		return this.tblcontrolAccesosOrds;
	}

	public void setTblcontrolAccesosOrds(List<ControlAccesosOrd> tblcontrolAccesosOrds) {
		this.tblcontrolAccesosOrds = tblcontrolAccesosOrds;
	}

	public ControlAccesosOrd addTblcontrolAccesosOrd(ControlAccesosOrd tblcontrolAccesosOrd) {
		getTblcontrolAccesosOrds().add(tblcontrolAccesosOrd);
		tblcontrolAccesosOrd.setTblcodigoUsuario(this);

		return tblcontrolAccesosOrd;
	}

	public ControlAccesosOrd removeTblcontrolAccesosOrd(ControlAccesosOrd tblcontrolAccesosOrd) {
		getTblcontrolAccesosOrds().remove(tblcontrolAccesosOrd);
		tblcontrolAccesosOrd.setTblcodigoUsuario(null);

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
		tblcontrolDiario.setTblcodigoUsuario(this);

		return tblcontrolDiario;
	}

	public ControlDiario removeTblcontrolDiario(ControlDiario tblcontrolDiario) {
		getTblcontrolDiarios().remove(tblcontrolDiario);
		tblcontrolDiario.setTblcodigoUsuario(null);

		return tblcontrolDiario;
	}

}