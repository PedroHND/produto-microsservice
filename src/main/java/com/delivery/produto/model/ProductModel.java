package com.delivery.produto.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLRestriction("datadelete IS NULL")
@Table(name = "TB_Produto")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column ( name = "nomeproduto", nullable = false)
    private String nomeProduto;

    @Column ( name = "descricaoproduto", nullable = false)
    private String descricaoProduto;

    @Column ( name = "precoproduto", nullable = false)
    private Double precoProduto;

    @Column ( name = "ativo", nullable = false)
    private Boolean ativo;

    @CreationTimestamp
    @Column(name = "datainsert", nullable = false, updatable = false)
    private LocalDateTime datainsert;

    @Column(name = "datadelete", nullable = true)
    private LocalDateTime dataDelete;






}
