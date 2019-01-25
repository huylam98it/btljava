package baitaplonjava.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the HOCVIEN database table.
 * 
 */
@Entity
@Table(name = "HOCVIEN")
public class HocVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hocvien_ma")
	private int hocvienMa;

	@Column(name = "hocvien_sdt")
	private String hocvienSdt;

	@Column(name = "hocvien_ten")
	private String hocvienTen;

	@Column(name = "hovien_tuoi")
	private int hovienTuoi;

	// bi-directional many-to-many association to Khoahoc
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "HOCVIEN_KHOAHOC", joinColumns = { @JoinColumn(name = "hocvien_ma") }, inverseJoinColumns = {
			@JoinColumn(name = "khoahoc_ma") })
	private List<KhoaHoc> khoahocs;

	public HocVien() {
	}

	public int getHocvienMa() {
		return this.hocvienMa;
	}

	public void setHocvienMa(int hocvienMa) {
		this.hocvienMa = hocvienMa;
	}

	public String getHocvienSdt() {
		return this.hocvienSdt;
	}

	public void setHocvienSdt(String hocvienSdt) {
		this.hocvienSdt = hocvienSdt;
	}

	public String getHocvienTen() {
		return this.hocvienTen;
	}

	public void setHocvienTen(String hocvienTen) {
		this.hocvienTen = hocvienTen;
	}

	public int getHocvienTuoi() {
		return this.hovienTuoi;
	}

	public void setHocvienTuoi(int hovienTuoi) {
		this.hovienTuoi = hovienTuoi;
	}

	public List<KhoaHoc> getKhoahocs() {
		return this.khoahocs;
	}

	public void setKhoahocs(List<KhoaHoc> khoahocs) {
		this.khoahocs = khoahocs;
	}

}