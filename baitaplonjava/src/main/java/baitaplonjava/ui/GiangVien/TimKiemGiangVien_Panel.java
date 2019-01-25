package baitaplonjava.ui.GiangVien;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import baitaplonjava.Exception.ThieuThongTinEx;
import baitaplonjava.Main.MainApp;
import baitaplonjava.model.GiangVien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TimKiemGiangVien_Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	private GiangVien_Panel parrent;

	public TimKiemGiangVien_Panel() {
		setFont(new Font("Arial", Font.BOLD, 18));
		this.setLayout(null);
		this.setSize(1400, 800);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "ID giảng viên", "Tên giảng viên", "số điện thoại", "Số lớp dạy" }) {

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

		JLabel lblNewLabel = new JLabel("TÌM KIẾM GIẢNG VIÊN", JLabel.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(500, 47, 400, 62);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(584, 148, 239, 40);
		add(textField);
		textField.setColumns(10);

		JLabel lblTnGingVin = new JLabel("Tên giảng viên", JLabel.RIGHT);
		lblTnGingVin.setBounds(473, 148, 99, 40);
		add(lblTnGingVin);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBounds(835, 148, 97, 40);
		btnTmKim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String str = textField.getText().trim();
					if (str.equals("")) {
						throw new ThieuThongTinEx();
					}
					while (table.getRowCount() > 0) {
						model.removeRow(0);
					}
					int stt = 1;
					List<GiangVien> gvs = MainApp.giangvienDao.search(str);
					for (GiangVien gv : gvs) {
						model.addRow(new Object[] { stt, gv.getGiangvienMa(), gv.getGiangvienTen(),
								gv.getGiangvienSdt(), gv.getKhoahocs().size() });
						stt += 1;
					}
				} catch (ThieuThongTinEx ex) {
					// TODO: handle exception
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		add(btnTmKim);

		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.setBounds(56, 69, 111, 40);
		btnQuayLi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parrent.timKiemGiangVien_Panel.setVisible(false);
				parrent.quanLyGiangVien_Panel.setVisible(true);
			}
		});
		add(btnQuayLi);

	}

	public void loadData() {

	}

	public void setParrent(GiangVien_Panel giangVien_Panel) {
		this.parrent = giangVien_Panel;
	}

}
