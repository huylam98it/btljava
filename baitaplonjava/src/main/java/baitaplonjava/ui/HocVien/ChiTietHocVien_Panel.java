package baitaplonjava.ui.HocVien;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import baitaplonjava.Exception.ThieuThongTinEx;
import baitaplonjava.Main.MainApp;
import baitaplonjava.model.HocVien;
import baitaplonjava.model.KhoaHoc;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ChiTietHocVien_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel model;
	private HocVien_Panel parrent;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public HocVien hv;

	public ChiTietHocVien_Panel() {
		this.setLayout(null);
		this.setSize(1400, 800);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "stt", "id khóa học", "tên khóa học", "học phí", "giảng viên" }) {
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

		JLabel lblMHcVin = new JLabel("Mã học viên", JLabel.CENTER);
		lblMHcVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMHcVin.setBounds(377, 48, 111, 40);
		add(lblMHcVin);

		JLabel lblTnHcVin = new JLabel("Tên học viên", JLabel.CENTER);
		lblTnHcVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnHcVin.setBounds(377, 115, 111, 40);
		add(lblTnHcVin);

		JLabel lblTuiHcVin = new JLabel("Tuổi học viên", JLabel.CENTER);
		lblTuiHcVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTuiHcVin.setBounds(377, 186, 111, 40);
		add(lblTuiHcVin);

		JLabel lblSinThoi = new JLabel("Số điện thoại", JLabel.CENTER);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(377, 259, 111, 40);
		add(lblSinThoi);

		textField = new JTextField();
		textField.setBounds(500, 48, 254, 40);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(500, 115, 254, 40);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(500, 186, 254, 40);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(500, 259, 254, 40);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblKhaHcTham = new JLabel("Khóa học tham gia", JLabel.CENTER);
		lblKhaHcTham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhaHcTham.setBounds(500, 326, 400, 49);
		add(lblKhaHcTham);

		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.setBounds(92, 48, 111, 40);
		btnQuayLi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parrent.chiTietHocVien_Panel.setVisible(false);
				parrent.quanLyHocVien_Panel.setVisible(true);

			}
		});
		add(btnQuayLi);

		JLabel lblThmKhaHc = new JLabel("Thêm khóa học");
		lblThmKhaHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThmKhaHc.setBounds(1046, 48, 146, 40);
		add(lblThmKhaHc);

		JLabel lblMKhaHc = new JLabel("Mã khóa học");
		lblMKhaHc.setBounds(923, 115, 84, 40);
		add(lblMKhaHc);

		textField_4 = new JTextField();
		textField_4.setBounds(1027, 115, 130, 40);
		add(textField_4);
		textField_4.setColumns(10);

		JButton btnThm = new JButton("Thêm");
		btnThm.setBounds(1169, 115, 111, 40);
		btnThm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String str = textField_4.getText().trim();
					if (str.equals("")) {
						throw new ThieuThongTinEx();
					}
					int maKh = Integer.parseInt(str);
					KhoaHoc kh = MainApp.khoahocDao.findById(maKh).get();
					hv.getKhoahocs().add(kh);
					MainApp.hocvienDao.save(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Thêm khóa học thành công");
				} catch (ThieuThongTinEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy nhập mã khóa học");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Thêm khóa học không thành công");
				}

			}
		});
		add(btnThm);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(1169, 188, 111, 38);
		btnXa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String str = textField_4.getText().trim();
					if (str.equals("")) {
						throw new ThieuThongTinEx();
					}
					int maKh = Integer.parseInt(str);
					KhoaHoc kh = MainApp.khoahocDao.findById(maKh).get();
					System.err.println(hv.getKhoahocs().size());
					hv.getKhoahocs().remove(kh);
					System.err.println(hv.getKhoahocs().size());
					MainApp.hocvienDao.save(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Xóa khóa học thành công");
				} catch (ThieuThongTinEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy nhập mã khóa học");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Xóa khóa học không thành công");
				}
			}
		});
		add(btnXa);
	}

	public void loadData() {
		HocVien hocVien = MainApp.hocvienDao.findById(hv.getHocvienMa()).get();
		textField.setText(hv.getHocvienMa() + "");
		textField_1.setText(hv.getHocvienTen());
		textField_2.setText(hv.getHocvienTuoi() + "");
		textField_3.setText(hv.getHocvienSdt());

		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}

		System.err.println("da load");
		List<KhoaHoc> khs = hocVien.getKhoahocs();
		int stt = 1;
		for (KhoaHoc kh : khs) {
			model.addRow(new Object[] { stt, kh.getKhoahocMa(), kh.getKhoahocTen(), kh.getKhoahocGia(),
					kh.getGiangvienBean().getGiangvienTen() });
			stt += 1;
		}

	}

	public void setParrent(HocVien_Panel hocVien_Panel) {
		this.parrent = hocVien_Panel;
	}

}
