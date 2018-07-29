package com.bringto.data.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bringto.data.model.Inspection;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Integer> {

	@Query(value = "SELECT id FROM inspections WHERE enabled AND id_schedule IS NOT NULL", nativeQuery = true)
	List<BigDecimal> findIdFromInspections();
	
	@Query(value = "SELECT * FROM _bigdata2(?1)", nativeQuery = true)
	String findByData2(Integer id);

}
