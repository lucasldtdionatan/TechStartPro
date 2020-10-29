package com.techstartpro.lucastorrestest.repository;


import com.techstartpro.lucastorrestest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(Integer id);

    @Query( "SELECT p FROM Product p" +
            " INNER JOIN p.category c" +
            " WHERE (p.name = :_name OR :_name IS NULL) AND (p.description = :_description OR :_description IS NULL) AND (p.price = :_price OR :_price IS NULL) GROUP BY p")
    List<Product> filterProduct(@Param("_name") String name, @Param("_description") String description, @Param("_price") BigDecimal price);
//    @Query( "SELECT p FROM Product p" +
//            " INNER JOIN p.category c" +
//            " WHERE (p.name = :_name OR :_name IS NULL) AND (p.description = :_description OR :_description IS NULL) AND (p.price = :_price OR :_price IS NULL) AND c.name IN (:_category) GROUP BY p")
//    List<Product> filterProduct(@Param("_name") String name, @Param("_description") String description, @Param("_price") BigDecimal price, @Param("_category") List<String> category);
}
