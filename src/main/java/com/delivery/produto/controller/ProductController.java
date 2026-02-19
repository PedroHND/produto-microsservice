package com.delivery.produto.controller;

import com.delivery.produto.dto.ProductRequestDTO;
import com.delivery.produto.dto.ProductResponseDTO;
import com.delivery.produto.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @Operation(
            summary = "Inserir produto",
            description = "Rota utilizada para inserir um produto."
    )
    @PostMapping
    public ResponseEntity<ProductResponseDTO> salvarProduto(@Valid @RequestBody ProductRequestDTO produto ) {
        return  ResponseEntity.ok(productService.salvarProduto(produto));
    }

    @Operation(
            summary = "Buscar todos os produtos",
            description = "Rota utilizada listar todos os produtos."
    )
    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> procurarTodos() {
        return ResponseEntity.ok(productService.procurarTodos());
    }

    @Operation(
            summary = "Buscar todos os produtos Ativos",
            description = "Rota utilizada listar todos os produtos com o campo Ativo=TRUE."
    )
    @GetMapping("/cardapio")
    public ResponseEntity<List<ProductResponseDTO>> procurarTodosAtivos() {
        return ResponseEntity.ok(productService.procurarTodosAtivos());
    }

    @Operation(
            summary = "Buscar produto",
            description = "Rota utilizada listar o produto pelo Id."
    )
    @GetMapping("/verificar/{idProduto}")
    public ResponseEntity<ProductResponseDTO> verificarProdutoCompleto(@PathVariable("idProduto") Long idProduto){
        return  ResponseEntity.ok(productService.procurarPorID(idProduto));
    }

    @Operation(
            summary = "Buscar produto ativo",
            description = "Rota utilizada listar o produto pelo Id caso ele esteja com o campo Ativo=TRUE."
    )
    @GetMapping("/{idProduto}")
    public ResponseEntity<ProductResponseDTO> buscarProdutoAtivo(@PathVariable("idProduto") Long idProduto) {
        return ResponseEntity.ok(productService.procurarPorIDAtivo(idProduto));
    }

    @Operation(
            summary = "Atualizar Produto",
            description = "Rota utilizada atualizar um produto."
    )
    @PutMapping("/atualizar/{idProduto}")
    public ResponseEntity<ProductResponseDTO> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProductRequestDTO produto){

        return  ResponseEntity.ok(productService.atualizarProduto(idProduto, produto));
    }

    @Operation(
            summary = "Inativar Produto",
            description = "Rota utilizada alterar o campo Ativo para o valor False."
    )
    @PatchMapping("/inativar/{idProduto}")
    public ResponseEntity<Void> inativarPorID(@PathVariable Long idProduto){
        productService.inativarPorID(idProduto);
        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Ativar Produto",
            description = "Rota utilizada alterar o campo Ativo para o valor True."
    )
    @PatchMapping("/ativar/{idProduto}")
    public ResponseEntity<Void> ativarPorID(@PathVariable Long idProduto){
        productService.ativarPorID(idProduto);
        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Apagar Produto",
            description = "Rota utilizada deletar o produto."
    )
    @PutMapping("/deletar/{idProduto}")
    public ResponseEntity<Void> deletarPorID(@PathVariable Long idProduto){
        productService.excluirProdutoLogico(idProduto);
        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Recuperar Produto",
            description = "Rota utilizada recuperar o produto do backup."
    )
    @PutMapping("/recuperar/{idProduto}")
    public ResponseEntity<Void> recuperarPorID(@PathVariable Long idProduto){
        productService.recuperarProduto(idProduto);
        return  ResponseEntity.noContent().build();
    }





}
