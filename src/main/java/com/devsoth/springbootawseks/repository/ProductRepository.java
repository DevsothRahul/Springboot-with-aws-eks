package com.devsoth.springbootawseks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsoth.springbootawseks.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
