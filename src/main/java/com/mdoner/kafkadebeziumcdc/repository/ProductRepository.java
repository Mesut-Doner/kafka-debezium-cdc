package com.mdoner.kafkadebeziumcdc.repository;

import com.mdoner.kafkadebeziumcdc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
