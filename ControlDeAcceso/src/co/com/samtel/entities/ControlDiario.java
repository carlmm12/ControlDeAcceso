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

	@Column(name="codigo_usuario")
	private int codigoUsuario;

	private int entrada;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;

	private int salida;

	private Time tiempo;

	public ControlDiario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public int getEntrada() {
		return this.entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalida() {
		return this.salida;
	}

	public void setSalida(int salida) {
		this.salida = salida;
	}

	public Time getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

}