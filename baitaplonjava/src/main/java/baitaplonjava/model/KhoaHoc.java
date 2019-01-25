package baitaplonjava.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the KHOAHOC database table.
 * 
 */
@Entity
@Table(name = "KHOAHOC")
public class KhoaHoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "khoahoc_ma")
	private int khoahocMa;

	@Column(name = "khoahoc_gia")
	private int khoahocGia;

	@Column(name = "khoahoc_ten")
	private String khoahocTen;

	@ManyToMany(mappedBy = "khoahocs", fetch = FetchType.EAGER)
	private List<HocVien> hocviens = new ArrayList<HocVien>();

	@ManyToOne
	@JoinColumn(name = "giangvien")
	private GiangVien giangvienBean;

	public KhoaHoc() {
	}

	public int getKhoahocMa() {
		return this.khoahocMa;
	}

	public void setKhoahocMa(int khoahocMa) {
		this.khoahocMa = khoahocMa;
	}

	public int getKhoahocGia() {
		return this.khoahocGia;
	}

	public void setKhoahocGia(int khoahocGia) {
		this.khoahocGia = khoahocGia;
	}

	public String getKhoahocTen() {
		return this.khoahocTen;
	}

	public void setKhoahocTen(String khoahocTen) {
		this.khoahocTen = khoahocTen;
	}

	public List<HocVien> getHocviens() {
		return this.hocviens;
	}

	public void setHocviens(List<HocVien> hocviens) {
		this.hocviens = hocviens;
	}

	public GiangVien getGiangvienBean() {
		return this.giangvienBean;
	}

	public void setGiangvienBean(GiangVien giangvienBean) {
		this.giangvienBean = giangvienBean;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		KhoaHoc kh=null;
		if (obj instanceof KhoaHoc) {
			kh = (KhoaHoc) obj;
		}
		return this.khoahocMa == kh.getKhoahocMa();
	}
}