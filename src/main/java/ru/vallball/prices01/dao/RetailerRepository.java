package ru.vallball.prices01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.prices01.model.Retailer;

public interface RetailerRepository extends JpaRepository<Retailer, Long>{
	
	public Retailer findRetailerByName(String name);

	public List<Retailer> findAllByOrderByNameAsc();

	public long deleteRetailerByName(String name);

}
