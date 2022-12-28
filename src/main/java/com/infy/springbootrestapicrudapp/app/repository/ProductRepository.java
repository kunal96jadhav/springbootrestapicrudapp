package com.infy.springbootrestapicrudapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.springbootrestapicrudapp.app.model.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<Product> findByProductId(Integer productId);

}
