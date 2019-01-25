package baitaplonjava.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import baitaplonjava.model.GiangVien;

@Repository("giangvienDao")
public interface GiangVienDao extends JpaRepository<GiangVien, Integer> {

	@Query("select g from GiangVien g join fetch g.khoahocs where g.giangvienMa = :id")
	public GiangVien getGiangVien(@Param("id") int id);

	@Query("select g from GiangVien g")
	public List<GiangVien> getPage(Pageable page);

	@Query("select gv from GiangVien gv where gv.giangvienTen like concat('%',:str,'%')")
	public List<GiangVien> search(@Param("str") String str);
}
