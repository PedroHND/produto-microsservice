package com.delivery.produto.service;

import com.delivery.produto.dto.ProductRequestDTO;
import com.delivery.produto.dto.ProductResponseDTO;

import java.util.List;

public interface IProductService {

    List<ProductResponseDTO> procurarTodos();

    ProductResponseDTO salvarProduto(ProductRequestDTO productRequestDTO);

    ProductResponseDTO procurarPorID(Long id);

    void inativarPorID(Long id);

    ProductResponseDTO atualizarProduto(Long idProduto, ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> procurarTodosAtivos();

    ProductResponseDTO procurarPorIDAtivo(Long id);

    void excluirProdutoLogico(Long id);

    void recuperarProduto(Long id);
}