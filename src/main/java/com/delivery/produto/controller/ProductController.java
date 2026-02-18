package com.delivery.produto.controller;

import com.delivery.produto.dto.ProductRequestDTO;
import com.delivery.produto.dto.ProductResponseDTO;
import com.delivery.produto.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> salvarProduto(@RequestBody ProductRequestDTO produto ) {
        return  ResponseEntity.ok(productService.salvarProduto(produto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> procurarTodos() {
        return ResponseEntity.ok(productService.procurarTodos());
    }

    @GetMapping("/cardapio")
    public ResponseEntity<List<ProductResponseDTO>> procurarTodosAtivos() {
        return ResponseEntity.ok(productService.procurarTodosAtivos());
    }

    @GetMapping("/verificar/{idProduto}")
    public ResponseEntity<ProductResponseDTO> verificarProdutoCompleto(@PathVariable("idProduto") Long idProduto){
        return  ResponseEntity.ok(productService.procurarPorID(idProduto));
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProductResponseDTO> buscarProdutoAtivo(@PathVariable("idProduto") Long idProduto) {
        return ResponseEntity.ok(productService.procurarPorIDAtivo(idProduto));
    }

    @PutMapping("/atualizar/{idProduto}")
    public ResponseEntity<ProductResponseDTO> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProductRequestDTO produto){

        return  ResponseEntity.ok(productService.atualizarProduto(idProduto, produto));
    }

    @PatchMapping("/inativar/{idProduto}")
    public ResponseEntity<Void> inativarPorID(@PathVariable Long idProduto){
        productService.inativarPorID(idProduto);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/deletar/{idProduto}")
    public ResponseEntity<Void> deletarPorID(@PathVariable Long idProduto){
        productService.excluirProdutoLogico(idProduto);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/recuperar/{idProduto}")
    public ResponseEntity<Void> recuperarPorID(@PathVariable Long idProduto){
        productService.recuperarProduto(idProduto);
        return  ResponseEntity.noContent().build();
    }





}
