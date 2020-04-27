package com.capg.placeorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.placeorder.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
