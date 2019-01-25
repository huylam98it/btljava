package baitaplonjava.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import baitaplonjava.ui.GiangVien.GiangVien_Panel;
import baitaplonjava.ui.HocVien.HocVien_Panel;
import baitaplonjava.ui.KhoaHoc.KhoaHoc_Panel;

public class Main_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Main_Panel() {
		this.setLayout(null);
		this.setSize(1400, 800);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1400, 800);
		add(tabbedPane);

		tabbedPane.addTab("Quan ly giang vien", new GiangVien_Panel());
		tabbedPane.addTab("Quan ly hoc vien", new HocVien_Panel());
		tabbedPane.addTab("Quan ly khoa hoc", new KhoaHoc_Panel());
	}

}
