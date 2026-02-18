package com.delivery.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    @JsonProperty(required = true)
    private Long idProduto;
    @JsonProperty(required = true)
    private String nomeProduto;
    @JsonProperty(required = true)
    private String descricaoProduto;
    @JsonProperty(required = true)
    private Double precoProduto;
    @JsonProperty(required = true)
    private Boolean ativo;

}
