package com.practise.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.productmanagement.model.Product;

//For connecting to database
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
  
}
