package baitaplonjava.ui.KhoaHoc;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import baitaplonjava.Exception.ThieuThongTinEx;
import baitaplonjava.Main.MainApp;
import baitaplonjava.model.HocVien;
import baitaplonjava.model.KhoaHoc;

public class ChiTietKhoaHoc_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private KhoaHoc_Panel parrent;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public KhoaHoc kh;
	private JTextField textField_4;

	public ChiTietKhoaHoc_Panel() {
		this.setLayout(null);
		this.setSize(1400, 800);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã học viên", "Tên học viên", "Tuổi", "Số điện thoại" }) {
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
		scrollPane.setBounds(0, 387, 1400, 400);
		add(scrollPane);

		JLabel lblDanhSchHc = new JLabel("Danh sách học viên", JLabel.CENTER);
		lblDanhSchHc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDanhSchHc.setBounds(500, 324, 400, 37);
		add(lblDanhSchHc);

		JLabel lblMKhaHc = new JLabel("Mã Khóa học");
		lblMKhaHc.setBounds(324, 38, 82, 40);
		add(lblMKhaHc);

		textField = new JTextField();
		textField.setBounds(418, 38, 306, 40);
		add(textField);
		textField.setColumns(10);

		JLabel lblTnKhaHc = new JLabel("Tên khóa học");
		lblTnKhaHc.setBounds(324, 103, 82, 40);
		add(lblTnKhaHc);

		textField_1 = new JTextField();
		textField_1.setBounds(418, 103, 306, 40);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblHcPh = new JLabel("Học phí");
		lblHcPh.setBounds(324, 172, 82, 40);
		add(lblHcPh);

		textField_2 = new JTextField();
		textField_2.setBounds(418, 172, 306, 40);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblMGingVin = new JLabel("Mã giảng viên");
		lblMGingVin.setBounds(324, 243, 82, 40);
		add(lblMGingVin);

		textField_3 = new JTextField();
		textField_3.setBounds(418, 243, 306, 40);
		add(textField_3);
		textField_3.setColumns(10);

		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.setBounds(84, 60, 123, 40);
		btnQuayLi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parrent.chiTietKhoaHoc_Panel.setVisible(false);
				parrent.quanLyKhoaHoc_Panel.setVisible(true);
			}
		});
		add(btnQuayLi);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(1143, 172, 97, 40);
		btnXa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String mhv = textField_4.getText().trim();
					if (mhv.equals("")) {
						throw new ThieuThongTinEx();
					}
					HocVien hv = MainApp.hocvienDao.findById(Integer.parseInt(mhv)).get();
					hv.getKhoahocs().remove(kh);
					MainApp.hocvienDao.save(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Xóa học viên thành công");
				} catch (ThieuThongTinEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy nhập mã học viên");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Xóa học viên không thành công");
				}

			}
		});
		add(btnXa);

		JLabel lblThmHcVin = new JLabel("Thêm học viên");
		lblThmHcVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThmHcVin.setBounds(1038, 48, 123, 37);
		add(lblThmHcVin);

		JLabel lblMHcVin = new JLabel("Mã học viên", JLabel.RIGHT);
		lblMHcVin.setBounds(908, 103, 88, 40);
		add(lblMHcVin);

		textField_4 = new JTextField();
		textField_4.setBounds(1008, 103, 123, 40);
		add(textField_4);
		textField_4.setColumns(10);

		JButton btnThm = new JButton("Thêm");
		btnThm.setBounds(1143, 103, 97, 40);
		btnThm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String mhv = textField_4.getText().trim();
					if (mhv.equals("")) {
						throw new ThieuThongTinEx();
					}
					HocVien hv = MainApp.hocvienDao.findById(Integer.parseInt(mhv)).get();
					hv.getKhoahocs().add(kh);
					MainApp.hocvienDao.save(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Thêm học viên thành công");
				} catch (ThieuThongTinEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy nhập mã học viên");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Thêm học viên không thành công");
				}
			}
		});
		add(btnThm);
	}

	public void loadData() {
		KhoaHoc kHoc = MainApp.khoahocDao.findById(kh.getKhoahocMa()).get();
		textField.setText(kh.getKhoahocMa() + "");
		textField_1.setText(kh.getKhoahocTen());
		textField_2.setText(kh.getKhoahocGia() + "");
		textField_3.setText(kh.getGiangvienBean().getGiangvienMa() + "");

		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}

		List<HocVien> hocviens = kHoc.getHocviens();

		int stt = 1;
		for (HocVien hv : hocviens) {
			model.addRow(new Object[] { stt, hv.getHocvienMa(), hv.getHocvienTen(), hv.getHocvienTuoi(),
					hv.getHocvienSdt() });
			stt += 1;
		}
	}

	public void setParrent(KhoaHoc_Panel panel) {
		this.parrent = panel;
	}

}
