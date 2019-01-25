package baitaplonjava.ui.KhoaHoc;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import baitaplonjava.Main.MainApp;
import baitaplonjava.model.KhoaHoc;

import javax.swing.JButton;

public class TimKiemKhoaHoc_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private KhoaHoc_Panel parrent;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;

	public TimKiemKhoaHoc_Panel() {
		this.setLayout(null);
		this.setSize(1400, 800);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Id khóa học", "Tên khóa học", "Học phí", "Giáo viên", "số học viên" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		table = new JTable(model);
		table.setRowHeight(40);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 300, 1400, 500);
		add(scrollPane);

		JLabel lblTmKimKha = new JLabel("TÌM KIẾM KHÓA HỌC", JLabel.CENTER);
		lblTmKimKha.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTmKimKha.setBounds(500, 60, 400, 58);
		add(lblTmKimKha);

		JLabel lblTnKhaHc = new JLabel("Tên khóa học");
		lblTnKhaHc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnKhaHc.setBounds(473, 177, 97, 40);
		add(lblTnKhaHc);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(582, 177, 243, 40);
		add(textField);
		textField.setColumns(10);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBounds(852, 177, 97, 40);
		btnTmKim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText().trim();
				if (!str.equals("")) {
					while (table.getRowCount() > 0) {
						model.removeRow(0);
					}
					int stt = 1;
					List<KhoaHoc> khoahocs = MainApp.khoahocDao.Search(str);
					for (KhoaHoc kh : khoahocs) {
						model.addRow(new Object[] { stt, kh.getKhoahocMa(), kh.getKhoahocTen(), kh.getKhoahocGia(),
								kh.getGiangvienBean().getGiangvienTen(), kh.getHocviens().size() });
						stt += 1;
					}
				}

			}
		});
		add(btnTmKim);

		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.setBounds(76, 70, 97, 40);
		btnQuayLi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parrent.timKiemKhoaHoc_Panel.setVisible(false);
				parrent.quanLyKhoaHoc_Panel.setVisible(true);
			}
		});
		add(btnQuayLi);
	}

	public void setParrent(KhoaHoc_Panel panel) {
		this.parrent = panel;
	}
}
