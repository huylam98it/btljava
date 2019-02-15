package baitaplonjava.ui.GiangVien;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import baitaplonjava.model.GiangVien;
import baitaplonjava.model.KhoaHoc;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChiTietGiangVien_panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private GiangVien_Panel parrent;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public GiangVien gv;

	public ChiTietGiangVien_panel() {
		this.setLayout(null);
		this.setSize(1400, 800);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Id khÃ³a há»�c", "TÃªn khÃ³a há»�c", "Há»�c phÃ­" }) {
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
		scrollPane.setBounds(0, 400, 1400, 400);
		add(scrollPane);

		textField = new JTextField();
		textField.setBounds(609, 129, 219, 40);
		add(textField);
		textField.setColumns(10);

		JLabel lblTnGingVin = new JLabel("TÃªn giáº£ng viÃªn");
		lblTnGingVin.setBounds(506, 129, 91, 40);
		add(lblTnGingVin);

		JLabel lblSinThoi = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i");
		lblSinThoi.setBounds(522, 205, 75, 40);
		add(lblSinThoi);

		textField_1 = new JTextField();
		textField_1.setBounds(609, 205, 219, 40);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblCcLpang = new JLabel("CÃ�C Lá»šP Ä�ANG Dáº Y", JLabel.CENTER);
		lblCcLpang.setFont(new Font("Arial", Font.BOLD, 18));
		lblCcLpang.setBounds(506, 279, 374, 59);
		add(lblCcLpang);

		JLabel lblMGingVin = new JLabel("MÃ£ giáº£ng viÃªn");
		lblMGingVin.setBounds(506, 55, 91, 40);
		add(lblMGingVin);

		textField_2 = new JTextField();
		textField_2.setBounds(609, 55, 219, 40);
		add(textField_2);
		textField_2.setColumns(10);

		JButton btnQuayLi = new JButton("Quay láº¡i");
		btnQuayLi.setBounds(46, 55, 110, 40);
		btnQuayLi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				parrent.chiTietGiangVien_panel.setVisible(false);
				parrent.quanLyGiangVien_Panel.setVisible(true);

			}
		});
		add(btnQuayLi);

	}

	public void loadData() {
		while(table.getRowCount()>0) {
			model.removeRow(0);
		}
		textField_2.setText(this.gv.getGiangvienMa() + "");
		textField.setText(this.gv.getGiangvienTen());
		textField_1.setText(this.gv.getGiangvienSdt());

		int stt = 1;
		for (KhoaHoc kh : gv.getKhoahocs()) {
			model.addRow(new Object[] { stt, kh.getKhoahocMa(), kh.getKhoahocTen(), kh.getKhoahocGia() });
			stt+=1;
		}

	}

	public void setParrent(GiangVien_Panel giangVien_Panel) {
		this.parrent = giangVien_Panel;
	}

}
