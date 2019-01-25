package baitaplonjava.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main_Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Main_Frame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showOptionDialog(null, "ban co muon thoat khong", "xac nhan dong cua so",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "dong y", "khong" }, JOptionPane.NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					e.getWindow().dispose();
				}
			}
		});
		this.setContentPane(new Main_Panel());
		this.setSize(1400, 840);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

}
