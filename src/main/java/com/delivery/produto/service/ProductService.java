package com.delivery.produto.service;

import com.delivery.produto.dto.ProductRequestDTO;
import com.delivery.produto.dto.ProductResponseDTO;
import com.delivery.produto.mapstruct.IProductMapper;
import com.delivery.produto.model.ProductModel;
import com.delivery.produto.repository.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    private final IProductMapper productMapper = Mappers.getMapper(IProductMapper.class);

    @Override
    @Transactional
    public ProductResponseDTO salvarProduto(ProductRequestDTO productRequestDTO){
        return productMapper.productResponseDTO(
                productRepository.save(
                        productMapper.toModel(productRequestDTO)));
    }

    @Override
    public List<ProductResponseDTO> procurarTodos(){
        return productMapper.productResponseDTOList(productRepository.findAll());
    }

    @Override
    public ProductResponseDTO procurarPorID(Long idProduto){
        return productRepository.findById(idProduto)
                .map(productMapper::productResponseDTO)
                .orElseThrow(
                        () -> new EntityNotFoundException("Produto não encontrado ou inativo")
                );
    }

    public ProductResponseDTO atualizarProduto(Long idProduto, ProductRequestDTO produtoNovo){
        ProductModel produtoAtual = productRepository.findById(idProduto).orElseThrow(
                () -> new EntityNotFoundException("Produto não encontrado com o ID: " + idProduto)
        );

        productMapper.updateModel(produtoNovo, produtoAtual);
        ProductModel produtoAtualizado = productRepository.save(produtoAtual);

        return productMapper.productResponseDTO(produtoAtualizado);
    }

   @Override
    public void inativarPorID(Long idProduto){
        ProductModel productModel = productRepository.findById(idProduto).orElseThrow(
                () -> new EntityNotFoundException("ID " + idProduto + " não existe para inativação.")
        );
        productModel.setAtivo(false);
        productRepository.save(productModel);
   }

    @Override
    public void ativarPorID(Long idProduto){
        ProductModel productModel = productRepository.findById(idProduto).orElseThrow(
                () -> new EntityNotFoundException("ID " + idProduto + " não existe para inativação.")
        );
        productModel.setAtivo(true);
        productRepository.save(productModel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> procurarTodosAtivos() {
        List<ProductModel> produtos = productRepository.findAllByAtivoTrue();
        return productMapper.productResponseDTOList(produtos);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO procurarPorIDAtivo(Long idProduto) {
        return productRepository.findByIdProdutoAndAtivoTrue(idProduto)
                .map(productMapper::productResponseDTO)
                .orElseThrow(
                        () -> new EntityNotFoundException("Produto não encontrado ou inativo")
                );
    }

    @Override
    @Transactional
    public void excluirProdutoLogico(Long id) {
        ProductModel produto = productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Produto não encontrado")
                );

        produto.setDataDelete(LocalDateTime.now());

        productRepository.save(produto);
    }


    @Override
    @Transactional
    public void recuperarProduto(Long id) {
        ProductModel produto = productRepository.findByIdDeletado(id).orElseThrow(
                () -> new EntityNotFoundException("Produto não encontrado")
        );
        produto.setDataDelete(null);
        productRepository.save(produto);
    }
}
