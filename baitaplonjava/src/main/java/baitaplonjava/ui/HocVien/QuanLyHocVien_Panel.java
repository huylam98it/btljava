package baitaplonjava.ui.HocVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import baitaplonjava.Exception.ChuaChonEx;
import baitaplonjava.Exception.ThieuThongTinEx;
import baitaplonjava.Main.MainApp;
import baitaplonjava.model.HocVien;

public class QuanLyHocVien_Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	public Map<Integer, HocVien> data;
	int page;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private HocVien_Panel parrent;

	public QuanLyHocVien_Panel() {
		page = 0;
		data = new HashMap<Integer, HocVien>();

		this.setLayout(null);
		this.setSize(1400, 800);

		model = new DefaultTableModel(new Object[][] {}, new String[] { "stt", "Id học viên", "tên học viên",
				"tuổi học viên", "sdt học viên", "khóa học tham gia" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		table = new JTable(model);
		table.setRowHeight(40);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int current = table.getSelectedRow();
				HocVien hv = data.get(current);
				if (e.getClickCount() == 1) {
					textField.setText(hv.getHocvienTen());
					textField_2.setText(hv.getHocvienTuoi() + "");
					textField_1.setText(hv.getHocvienSdt());
				}
				if (e.getClickCount() == 2) {
					parrent.quanLyHocVien_Panel.setVisible(false);
					parrent.chiTietHocVien_Panel.hv = hv;
					parrent.chiTietHocVien_Panel.loadData();
					parrent.chiTietHocVien_Panel.setVisible(true);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 1400, 400);
		add(scrollPane);

		JButton btnQuayLi = new JButton("Tìm kiếm");
		btnQuayLi.setBounds(94, 509, 109, 40);
		btnQuayLi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parrent.quanLyHocVien_Panel.setVisible(false);
				parrent.timKiemHocVien_Panel.setVisible(true);
			}
		});
		add(btnQuayLi);

		JLabel lblTnHcVin = new JLabel("Tên học viên", JLabel.RIGHT);
		lblTnHcVin.setBounds(504, 509, 84, 40);
		add(lblTnHcVin);

		JLabel lblSinThoi = new JLabel("Số điện thoại", JLabel.RIGHT);
		lblSinThoi.setBounds(504, 572, 84, 40);
		add(lblSinThoi);

		JLabel lblTui = new JLabel("Tuổi", JLabel.RIGHT);
		lblTui.setBounds(504, 640, 84, 40);
		add(lblTui);

		textField = new JTextField();
		textField.setBounds(600, 509, 281, 40);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(600, 572, 281, 40);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(600, 640, 281, 40);
		add(textField_2);
		textField_2.setColumns(10);

		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(1165, 509, 109, 40);
		btnSa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int current = table.getSelectedRow();
					if (current == -1) {
						throw new ChuaChonEx();
					}
					HocVien hv = data.get(current);
					String name = textField.getText().trim();
					String sdt = textField_1.getText().trim();
					String tuoi = textField_2.getText().trim();
					if (name.equals("") || sdt.equals("") || tuoi.equals("")) {
						throw new ThieuThongTinEx();
					}
					hv.setHocvienTen(name);
					hv.setHocvienSdt(sdt);
					hv.setHocvienTuoi(Integer.parseInt(tuoi));
					MainApp.hocvienDao.save(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Sửa học viên thành công");
				} catch (ChuaChonEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy chọn học viên cần sửa");
				} catch (ThieuThongTinEx e2) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Sửa học viên không thành công");
				}

			}
		});
		add(btnSa);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(1165, 640, 109, 40);
		btnXa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int current = table.getSelectedRow();
					if (current == -1) {
						throw new ChuaChonEx();
					}
					HocVien hv = data.get(current);
					MainApp.hocvienDao.delete(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Xóa học viên thành công");
				} catch (ChuaChonEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy chọn học viên cần xóa");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Xóa học viên không thành công");
				}

			}
		});
		add(btnXa);

		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(94, 640, 109, 40);
		btnReload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		add(btnReload);

		JButton btnThm = new JButton("Thêm");
		btnThm.setBounds(666, 715, 109, 40);
		btnThm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textField.getText().trim();
					String sdt = textField_1.getText().trim();
					String tuoi = textField_2.getText().trim();
					if (name.equals("") || sdt.equals("") || tuoi.equals("")) {
						throw new ThieuThongTinEx();
					}
					int t = Integer.parseInt(tuoi);
					HocVien hv = new HocVien();
					hv.setHocvienTen(name);
					hv.setHocvienSdt(sdt);
					hv.setHocvienTuoi(t);
					MainApp.hocvienDao.save(hv);
					loadData();
					JOptionPane.showMessageDialog(null, "Thêm học viên thành công");
				} catch (ThieuThongTinEx ex) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Thêm học viên không thành công");
				}

			}
		});
		add(btnThm);

		JButton btnTrc = new JButton("Trước");
		btnTrc.setBounds(504, 437, 97, 40);
		add(btnTrc);

		JButton btnSau = new JButton("Sau");
		btnSau.setBounds(784, 437, 97, 40);
		add(btnSau);

		loadData();

	}

	public void loadData() {
		if (this.data.size() > 0) {
			this.data.clear();
		}
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
		int stt = 1;
		List<HocVien> hocviens = MainApp.hocvienDao.findAll();
		for (HocVien hv : hocviens) {
			model.addRow(new Object[] { stt, hv.getHocvienMa(), hv.getHocvienTen(), hv.getHocvienTuoi(),
					hv.getHocvienSdt(), hv.getKhoahocs().size() });
			data.put(stt - 1, hv);
			stt += 1;
		}
	}

	public void setParrent(HocVien_Panel hocVien_Panel) {
		this.parrent = hocVien_Panel;
	}

}
