package baitaplonjava.Main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import baitaplonjava.config.JpaConfig;
import baitaplonjava.dao.GiangVienDao;
import baitaplonjava.dao.HocVienDao;
import baitaplonjava.dao.HocVienKhoaHocDao;
import baitaplonjava.dao.KhoaHocDao;
import baitaplonjava.ui.Main_Frame;

public class MainApp {

	public static GiangVienDao giangvienDao;
	public static HocVienDao hocvienDao;
	public static HocVienKhoaHocDao hocvien_khoahocDao;
	public static KhoaHocDao khoahocDao;

	public static void init() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		MainApp.giangvienDao = context.getBean("giangvienDao", GiangVienDao.class);
		MainApp.hocvienDao = context.getBean("hocvienDao", HocVienDao.class);
		MainApp.hocvien_khoahocDao = context.getBean("hocvien_khoahocDao", HocVienKhoaHocDao.class);
		MainApp.khoahocDao = context.getBean("khoahocDao", KhoaHocDao.class);
	}

	public static void main(String[] args) {
		init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new WindowsLookAndFeel());
					Main_Frame frame = new Main_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
