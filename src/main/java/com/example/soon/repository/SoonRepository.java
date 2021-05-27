package com.example.soon.repository;

import com.example.soon.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoonRepository extends CrudRepository<Product,Long> {
}
