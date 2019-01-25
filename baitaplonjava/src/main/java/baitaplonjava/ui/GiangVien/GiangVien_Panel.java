package baitaplonjava.ui.GiangVien;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class GiangVien_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ChiTietGiangVien_panel chiTietGiangVien_panel;
	public QuanLyGiangVien_Panel quanLyGiangVien_Panel;
	public TimKiemGiangVien_Panel timKiemGiangVien_Panel;

	public GiangVien_Panel() {
		this.setLayout(new CardLayout());
		this.setSize(1400, 800);

		quanLyGiangVien_Panel = new QuanLyGiangVien_Panel();
		quanLyGiangVien_Panel.setParrent(this);

		chiTietGiangVien_panel = new ChiTietGiangVien_panel();
		chiTietGiangVien_panel.setParrent(this);

		timKiemGiangVien_Panel = new TimKiemGiangVien_Panel();
		timKiemGiangVien_Panel.setParrent(this);

		this.add(quanLyGiangVien_Panel);
		this.add(chiTietGiangVien_panel);
		this.add(timKiemGiangVien_Panel);
	}

}
