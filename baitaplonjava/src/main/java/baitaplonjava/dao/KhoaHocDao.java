package baitaplonjava.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import baitaplonjava.model.KhoaHoc;

@Repository("khoahocDao")
public interface KhoaHocDao extends JpaRepository<KhoaHoc, Integer> {

	@Query("select kh from KhoaHoc kh join fetch kh.giangvienBean join fetch kh.hocviens hv where kh.khoahocMa= :id")
	public KhoaHoc getKhoaHoc(@Param("id") int id);

	@Query("select kh from KhoaHoc kh")
	public List<KhoaHoc> getPage(Pageable page);

	@Query("select kh from KhoaHoc kh where kh.khoahocTen like concat('%',:str,'%')")
	public List<KhoaHoc> Search(@Param("str") String str);
}
