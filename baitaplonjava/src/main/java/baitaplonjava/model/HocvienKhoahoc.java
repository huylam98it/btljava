package baitaplonjava.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the HOCVIEN_KHOAHOC database table.
 * 
 */
@Entity
@Table(name = "HOCVIEN_KHOAHOC")
@NamedQuery(name = "HocvienKhoahoc.findAll", query = "SELECT h FROM HocvienKhoahoc h")
public class HocvienKhoahoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HocvienKhoahocPK id;

	private boolean dongtien;

	@ManyToOne
	@MapsId("hocvienMa")
	@JoinColumn(name = "hocvien_ma")
	private HocVien hocvien;

	@ManyToOne
	@MapsId("khoahocMa")
	@JoinColumn(name = "khoahoc_ma")
	private KhoaHoc khoahoc;

	public HocvienKhoahoc() {
	}

	public HocvienKhoahocPK getId() {
		return this.id;
	}

	public void setId(HocvienKhoahocPK id) {
		this.id = id;
	}

	public boolean getDongtien() {
		return this.dongtien;
	}

	public void setDongtien(boolean dongtien) {
		this.dongtien = dongtien;
	}

	public HocVien getHocvien() {
		return this.hocvien;
	}

	public void setHocvien(HocVien hocvien) {
		this.hocvien = hocvien;
	}

	public KhoaHoc getKhoahoc() {
		return this.khoahoc;
	}

	public void setKhoahoc(KhoaHoc khoahoc) {
		this.khoahoc = khoahoc;
	}

}