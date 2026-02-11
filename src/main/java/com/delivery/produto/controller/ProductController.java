package com.delivery.produto.controller;

import com.delivery.produto.model.ProductModel;
import com.delivery.produto.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody ProductModel  produto ) {
        productService.salvarProduto(produto);
        return  ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity findAll() {
        List<ProductModel> produtos =  productService.finAll();
        if(produtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity findById(@PathVariable Long idProduto){
        return  ResponseEntity.ok(productService.findById(idProduto));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteById(@RequestParam Long idProduto){
        productService.deleteById(idProduto);
        return  ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> atualizarProduto(@RequestParam Long idProduto, @RequestBody ProductModel  produto){
        productService.atualizarProduto(idProduto, produto);
        return  ResponseEntity.ok().build();
    }
}
