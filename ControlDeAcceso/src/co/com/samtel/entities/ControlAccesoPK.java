package co.com.samtel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the tbl_control_accesos database table.
 * 
 */
@Embeddable
public class ControlAccesoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String enno;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date datetime;

	public ControlAccesoPK() {
	}
	
	
	public ControlAccesoPK( Date datetime ,String enno) {
		super();
		this.enno = enno;
		this.datetime = datetime;
	}


	
	public String getEnno() {
		return enno;
	}


	public void setEnno(String enno) {
		this.enno = enno;
	}


	public java.util.Date getDatetime() {
		return this.datetime;
	}
	public void setDatetime(java.util.Date datetime) {
		this.datetime = datetime;
	}
	

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ControlAccesoPK)) {
			return false;
		}
		ControlAccesoPK castOther = (ControlAccesoPK)other;
		return 
			this.enno.equals(castOther.enno)
			&& this.datetime.equals(castOther.datetime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.enno.hashCode();
		hash = hash * prime + this.datetime.hashCode();
		
		return hash;
	}


	@Override
	public String toString() {
		return "ControlAccesoPK [enno=" + enno + ", datetime=" + datetime + "]";
	}
	
	
}