package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select p from Product p where p.name like :name")
	public Page<Product> productByName(@Param("name") String n, Pageable pageable);
	
	@Query("select p from Product p where p.quantity like :quantity")
	public Page<Product> ProductByQuantity(@Param("quantity") String quantity, Pageable pageable);

}
