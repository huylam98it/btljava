package baitaplonjava.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HOCVIEN_KHOAHOC database table.
 * 
 */
@Embeddable
public class HocvienKhoahocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hocvien_ma", insertable=false, updatable=false)
	private int hocvienMa;

	@Column(name="khoahoc_ma", insertable=false, updatable=false)
	private int khoahocMa;

	public HocvienKhoahocPK() {
	}
	public int getHocvienMa() {
		return this.hocvienMa;
	}
	public void setHocvienMa(int hocvienMa) {
		this.hocvienMa = hocvienMa;
	}
	public int getKhoahocMa() {
		return this.khoahocMa;
	}
	public void setKhoahocMa(int khoahocMa) {
		this.khoahocMa = khoahocMa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HocvienKhoahocPK)) {
			return false;
		}
		HocvienKhoahocPK castOther = (HocvienKhoahocPK)other;
		return 
			(this.hocvienMa == castOther.hocvienMa)
			&& (this.khoahocMa == castOther.khoahocMa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hocvienMa;
		hash = hash * prime + this.khoahocMa;
		
		return hash;
	}
}