package baitaplonjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import baitaplonjava.model.HocvienKhoahoc;
import baitaplonjava.model.HocvienKhoahocPK;

@Repository("hocvien_khoahocDao")
public interface HocVienKhoaHocDao extends JpaRepository<HocvienKhoahoc, HocvienKhoahocPK> {

}
