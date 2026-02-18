package com.delivery.produto.repository;

import com.delivery.produto.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findAllByAtivoTrue();

    Optional<ProductModel> findByIdProdutoAndAtivoTrue(Long idProduto);

    @Query(value = "SELECT * FROM tb_produto WHERE id_produto = :id", nativeQuery = true)
    Optional<ProductModel> findByIdDeletado(@Param("id") Long id);

}
