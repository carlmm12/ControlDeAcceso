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

	@Column(name="cantidad_registros")
	private int cantidadRegistros;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time tiempo;

	//bi-directional many-to-one association to ControlAccesosOrd
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entrada")
	private ControlAccesosOrd tblcontrolAccesosOrd1;

	//bi-directional many-to-one association to ControlAccesosOrd
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="salida")
	private ControlAccesosOrd tblcontrolAccesosOrd2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tblusuarios_id")
	private Usuario tblusuario;

	public ControlDiario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadRegistros() {
		return this.cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
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

	public ControlAccesosOrd getTblcontrolAccesosOrd1() {
		return this.tblcontrolAccesosOrd1;
	}

	public void setTblcontrolAccesosOrd1(ControlAccesosOrd tblcontrolAccesosOrd1) {
		this.tblcontrolAccesosOrd1 = tblcontrolAccesosOrd1;
	}

	public ControlAccesosOrd getTblcontrolAccesosOrd2() {
		return this.tblcontrolAccesosOrd2;
	}

	public void setTblcontrolAccesosOrd2(ControlAccesosOrd tblcontrolAccesosOrd2) {
		this.tblcontrolAccesosOrd2 = tblcontrolAccesosOrd2;
	}

	public Usuario getTblusuario() {
		return this.tblusuario;
	}

	public void setTblusuario(Usuario tblusuario) {
		this.tblusuario = tblusuario;
	}

}