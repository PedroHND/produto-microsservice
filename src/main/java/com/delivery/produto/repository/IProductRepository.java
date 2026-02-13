package com.delivery.produto.repository;

import com.delivery.produto.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductModel, Long> {

    @Transactional
    void deleteById(Long id);

}
