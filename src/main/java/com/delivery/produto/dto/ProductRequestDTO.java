package com.delivery.produto.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @JsonProperty(required = true)
    private String nomeProduto;
    @JsonProperty(required = true)
    private String descricaoProduto;
    @JsonProperty(required = true)
    private Double precoProduto;
    @JsonProperty(required = true)
    private Boolean ativo;

}
