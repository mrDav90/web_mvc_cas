package com.learn.david.web_mvc_cas.repositories;

import com.learn.david.web_mvc_cas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
