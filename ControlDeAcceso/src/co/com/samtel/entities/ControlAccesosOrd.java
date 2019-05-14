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

	//bi-directional many-to-one association to CodigoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tblcodigo_usuarios_codigo")
	private CodigoUsuario tblcodigoUsuario;

	//bi-directional many-to-one association to ControlDiario
	@OneToOne(mappedBy="entrada")
	private ControlDiario entrada;

	//bi-directional many-to-one association to ControlDiario
	@OneToOne(mappedBy="salida")
	private ControlDiario salida;

	public ControlAccesosOrd() {
	}
	
	

	
	public ControlAccesosOrd(int id, Date fecha, int tipoAcceso, CodigoUsuario tblcodigoUsuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoAcceso = tipoAcceso;
		this.tblcodigoUsuario = tblcodigoUsuario;
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

	public ControlDiario getEntrada() {
		return entrada;
	}

	public void setEntrada(ControlDiario entrada) {
		this.entrada = entrada;
	}

	public ControlDiario getSalida() {
		return salida;
	}

	public void setSalida(ControlDiario salida) {
		this.salida = salida;
	}

	@Override
	public String toString() {
		return "ControlAccesosOrd [id=" + id + ", fecha=" + fecha + ", tipoAcceso=" + tipoAcceso + ", tblcodigoUsuario="
				+ tblcodigoUsuario + "]";
	}
	

	

	
}