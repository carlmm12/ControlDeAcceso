package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblcontrol_accesos_ord database table.
 * 
 */
@Entity
@Table(name="tblcontrol_accesos_ord")
@NamedQuery(name="ControlAccesosOrd.findAll", query="SELECT c FROM ControlAccesosOrd c")
public class ControlAccesosOrd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name="tipo_acceso")
	private int tipoAcceso;
	
	

	public ControlAccesosOrd(int id, Date fecha, int tipoAcceso, CodigoUsuario tblcodigoUsuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoAcceso = tipoAcceso;
		this.tblcodigoUsuario = tblcodigoUsuario;
	}

	//bi-directional many-to-one association to CodigoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tblcodigo_usuarios_codigo")
	private CodigoUsuario tblcodigoUsuario;

	//bi-directional many-to-one association to ControlDiario
	@OneToMany(mappedBy="tblcontrolAccesosOrd1")
	private List<ControlDiario> tblcontrolDiarios1;

	//bi-directional many-to-one association to ControlDiario
	@OneToMany(mappedBy="tblcontrolAccesosOrd2")
	private List<ControlDiario> tblcontrolDiarios2;

	public ControlAccesosOrd() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTipoAcceso() {
		return this.tipoAcceso;
	}

	public void setTipoAcceso(int tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}

	public CodigoUsuario getTblcodigoUsuario() {
		return this.tblcodigoUsuario;
	}

	public void setTblcodigoUsuario(CodigoUsuario tblcodigoUsuario) {
		this.tblcodigoUsuario = tblcodigoUsuario;
	}

	public List<ControlDiario> getTblcontrolDiarios1() {
		return this.tblcontrolDiarios1;
	}

	public void setTblcontrolDiarios1(List<ControlDiario> tblcontrolDiarios1) {
		this.tblcontrolDiarios1 = tblcontrolDiarios1;
	}

	public ControlDiario addTblcontrolDiarios1(ControlDiario tblcontrolDiarios1) {
		getTblcontrolDiarios1().add(tblcontrolDiarios1);
		tblcontrolDiarios1.setTblcontrolAccesosOrd1(this);

		return tblcontrolDiarios1;
	}

	public ControlDiario removeTblcontrolDiarios1(ControlDiario tblcontrolDiarios1) {
		getTblcontrolDiarios1().remove(tblcontrolDiarios1);
		tblcontrolDiarios1.setTblcontrolAccesosOrd1(null);

		return tblcontrolDiarios1;
	}

	public List<ControlDiario> getTblcontrolDiarios2() {
		return this.tblcontrolDiarios2;
	}

	public void setTblcontrolDiarios2(List<ControlDiario> tblcontrolDiarios2) {
		this.tblcontrolDiarios2 = tblcontrolDiarios2;
	}

	public ControlDiario addTblcontrolDiarios2(ControlDiario tblcontrolDiarios2) {
		getTblcontrolDiarios2().add(tblcontrolDiarios2);
		tblcontrolDiarios2.setTblcontrolAccesosOrd2(this);

		return tblcontrolDiarios2;
	}

	public ControlDiario removeTblcontrolDiarios2(ControlDiario tblcontrolDiarios2) {
		getTblcontrolDiarios2().remove(tblcontrolDiarios2);
		tblcontrolDiarios2.setTblcontrolAccesosOrd2(null);

		return tblcontrolDiarios2;
	}

	@Override
	public String toString() {
		return "ControlAccesosOrd [id=" + id + ", fecha=" + fecha + ", tipoAcceso=" + tipoAcceso + ", tblcodigoUsuario="
				+ tblcodigoUsuario + "]";
	}

	
}