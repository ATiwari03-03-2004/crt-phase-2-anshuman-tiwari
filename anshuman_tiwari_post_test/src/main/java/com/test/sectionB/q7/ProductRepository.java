package com.test.sectionB.q7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products cheaper than :price within a given :category, using named parameters.
    @Query("SELECT p FROM Product p WHERE p.price < :price AND p.category = :category")
    List<Product> findCheaperInCategory(@Param("price") double price,
                                        @Param("category") String category);
}
