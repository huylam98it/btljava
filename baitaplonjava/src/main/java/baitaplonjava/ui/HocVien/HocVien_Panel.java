package baitaplonjava.ui.HocVien;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class HocVien_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public QuanLyHocVien_Panel quanLyHocVien_Panel;
	public ChiTietHocVien_Panel chiTietHocVien_Panel;
	public TimKiemHocVien_Panel timKiemHocVien_Panel;

	public HocVien_Panel() {
		this.setLayout(new CardLayout());
		this.setSize(1400, 800);

		quanLyHocVien_Panel = new QuanLyHocVien_Panel();
		quanLyHocVien_Panel.setParrent(this);

		chiTietHocVien_Panel = new ChiTietHocVien_Panel();
		chiTietHocVien_Panel.setParrent(this);

		timKiemHocVien_Panel = new TimKiemHocVien_Panel();
		timKiemHocVien_Panel.setParrent(this);

		this.add(quanLyHocVien_Panel);
		this.add(chiTietHocVien_Panel);
		this.add(timKiemHocVien_Panel);
	}

}
