package baitaplonjava.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the GIANGVIEN database table.
 * 
 */
@Entity
@Table(name = "GIANGVIEN")
public class GiangVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "giangvien_ma")
	private int giangvienMa;

	@Column(name = "giangvien_sdt")
	private String giangvienSdt;

	@Column(name = "giangvien_ten")
	private String giangvienTen;

	@OneToMany(mappedBy = "giangvienBean", fetch = FetchType.EAGER)
	private List<KhoaHoc> khoahocs;

	public GiangVien() {
	}

	public int getGiangvienMa() {
		return this.giangvienMa;
	}

	public void setGiangvienMa(int giangvienMa) {
		this.giangvienMa = giangvienMa;
	}

	public String getGiangvienSdt() {
		return this.giangvienSdt;
	}

	public void setGiangvienSdt(String giangvienSdt) {
		this.giangvienSdt = giangvienSdt;
	}

	public String getGiangvienTen() {
		return this.giangvienTen;
	}

	public void setGiangvienTen(String giangvienTen) {
		this.giangvienTen = giangvienTen;
	}

	public List<KhoaHoc> getKhoahocs() {
		return this.khoahocs;
	}

	public void setKhoahocs(List<KhoaHoc> khoahocs) {
		this.khoahocs = khoahocs;
	}

	public KhoaHoc addKhoahoc(KhoaHoc khoahoc) {
		getKhoahocs().add(khoahoc);
		khoahoc.setGiangvienBean(this);

		return khoahoc;
	}

	public KhoaHoc removeKhoahoc(KhoaHoc khoahoc) {
		getKhoahocs().remove(khoahoc);
		khoahoc.setGiangvienBean(null);

		return khoahoc;
	}

}