package co.com.samtel.entities;

import java.io.Serializable;
import javax.persistence.*;


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

	//bi-directional many-to-one association to Usuario
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
	private Usuario cedula;

	public CodigoUsuario() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Usuario getTblusuario() {
		return this.cedula;
	}

	public void setTblusuario(Usuario tblusuario) {
		this.cedula = tblusuario;
	}

}