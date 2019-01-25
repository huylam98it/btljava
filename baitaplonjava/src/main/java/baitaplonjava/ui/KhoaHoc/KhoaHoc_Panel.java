package baitaplonjava.ui.KhoaHoc;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class KhoaHoc_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public QuanLyKhoaHoc_Panel quanLyKhoaHoc_Panel;
	public ChiTietKhoaHoc_Panel chiTietKhoaHoc_Panel;
	public TimKiemKhoaHoc_Panel timKiemKhoaHoc_Panel;

	public KhoaHoc_Panel() {
		this.setLayout(new CardLayout());
		this.setSize(1400, 800);

		quanLyKhoaHoc_Panel = new QuanLyKhoaHoc_Panel();
		quanLyKhoaHoc_Panel.setParrent(this);

		chiTietKhoaHoc_Panel = new ChiTietKhoaHoc_Panel();
		chiTietKhoaHoc_Panel.setParrent(this);

		timKiemKhoaHoc_Panel = new TimKiemKhoaHoc_Panel();
		timKiemKhoaHoc_Panel.setParrent(this);

		this.add(quanLyKhoaHoc_Panel);
		this.add(chiTietKhoaHoc_Panel);
		this.add(timKiemKhoaHoc_Panel);
	}

}
