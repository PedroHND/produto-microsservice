package com.delivery.produto.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_Produto")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column ( name = "Nome_Produto", nullable = false)
    private String nomeProduto;

    @Column ( name = "Descricao_Produto", nullable = false)
    private String descricaoProduto;

    @Column ( name = "Preco_Produto", nullable = false)
    private Double precoProduto;

    @Column ( name = "Status_Produto", nullable = false)
    private Boolean ativo;

    public ProductModel(String nomeProduto, String descricaoProduto, double precoProduto, boolean ativo) {

        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.ativo = ativo;
    }


}
