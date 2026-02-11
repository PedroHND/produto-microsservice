package com.delivery.produto.service;

import com.delivery.produto.model.ProductModel;
import com.delivery.produto.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

     public List<ProductModel> finAll(){
        return  productRepository.findAll();
    }

    public void salvarProduto(ProductModel productModel){
        productRepository.save(productModel);
    }

    public ProductModel findById(Long id){
         return productRepository.findById(id).orElseThrow(
                 () -> new RuntimeException("Produto não encontrado")
         );
    }

    public void deleteById(Long id){
          productRepository.deleteById(id);
    }

    public void atualizarProduto(Long idProduto, ProductModel productModel){
         ProductModel produto = productRepository.findById(idProduto).orElseThrow(
                 () -> new RuntimeException("Produto não encontrado")
         );
         ProductModel produtoAtualizado = ProductModel.builder()
                 .idProduto(produto.getIdProduto())
                 .nomeProduto(productModel.getNomeProduto() != null ?
                         productModel.getNomeProduto() : produto.getNomeProduto())
                 .descricaoProduto(productModel.getDescricaoProduto() != null ?
                         productModel.getDescricaoProduto() : produto.getDescricaoProduto())
                 .precoProduto(productModel.getPrecoProduto() != null ?
                         productModel.getPrecoProduto() : produto.getPrecoProduto())
                 .ativo(productModel.getAtivo() != null ?
                         productModel.getAtivo() : produto.getAtivo())
                 .build();
         productRepository.saveAndFlush(produtoAtualizado);

    }

}
