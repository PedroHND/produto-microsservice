package com.delivery.produto.service;

import com.delivery.produto.dto.ProductRequestDTO;
import com.delivery.produto.dto.ProductResponseDTO;
import com.delivery.produto.mapstruct.IProductMapper;
import com.delivery.produto.model.ProductModel;
import com.delivery.produto.repository.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
    public ProductResponseDTO procurarPorID(Long id){
        return productMapper.productResponseDTO(productRepository.findById(id).get());
    }

    public ProductResponseDTO atualizarProduto(Long idProduto, ProductRequestDTO produtoNovo){
        ProductModel produtoAtual = productRepository.findById(idProduto).orElseThrow(
                () -> new RuntimeException("Produto não encontrado com ID: " + idProduto)
        );

        productMapper.updateModel(produtoNovo, produtoAtual);
        ProductModel produtoAtualizado = productRepository.save(produtoAtual);

        return productMapper.productResponseDTO(produtoAtualizado);
    }

   @Override
    public void inativarPorID(Long id){
        ProductModel productModel = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não Encontrado com ID: " + id)
        );
        productModel.setAtivo(false);
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
    public ProductResponseDTO procurarPorIDAtivo(Long id) {
        return productRepository.findByIdProdutoAndAtivoTrue(id)
                .map(productMapper::productResponseDTO)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado ou inativo"));
    }
    @Override
    @Transactional
    public void excluirProdutoLogico(Long id) {
        ProductModel produto = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        produto.setDataDelete(LocalDateTime.now());

        productRepository.save(produto);
    }


    @Override
    @Transactional
    public void recuperarProduto(Long id) {
        ProductModel produto = productRepository.findByIdDeletado(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        produto.setDataDelete(null);
        productRepository.save(produto);
    }
}
