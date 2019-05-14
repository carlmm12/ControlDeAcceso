package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the tblcontrol_diario database table.
 * 
 */
@Entity
@Table(name="tblcontrol_diario")
@NamedQuery(name="ControlDiario.findAll", query="SELECT c FROM ControlDiario c")
public class ControlDiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time tiempo;

	//bi-directional many-to-one association to CodigoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tblcodigo_usuarios_codigo")
	private CodigoUsuario tblcodigoUsuario;

	//bi-directional many-to-one association to ControlAccesosOrd
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entrada", referencedColumnName = "id")
	private ControlAccesosOrd entrada;

	//bi-directional many-to-one association to ControlAccesosOrd
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="salida", referencedColumnName = "id")
	private ControlAccesosOrd salida;

	public ControlDiario() {
	}
	

	public ControlDiario(int id, Date fecha, Time tiempo, CodigoUsuario tblcodigoUsuario, ControlAccesosOrd entrada,
			ControlAccesosOrd salida) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tiempo = tiempo;
		this.tblcodigoUsuario = tblcodigoUsuario;
		this.entrada = entrada;
		this.salida = salida;
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

	public Time getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

	public CodigoUsuario getTblcodigoUsuario() {
		return this.tblcodigoUsuario;
	}

	public void setTblcodigoUsuario(CodigoUsuario tblcodigoUsuario) {
		this.tblcodigoUsuario = tblcodigoUsuario;
	}

	public ControlAccesosOrd getEntrada() {
		return entrada;
	}

	public void setEntrada(ControlAccesosOrd entrada) {
		this.entrada = entrada;
	}

	public ControlAccesosOrd getSalida() {
		return salida;
	}

	public void setSalida(ControlAccesosOrd salida) {
		this.salida = salida;
	}

	

}