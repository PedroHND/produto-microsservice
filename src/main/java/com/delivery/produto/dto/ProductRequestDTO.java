package com.delivery.produto.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDTO {

    @JsonProperty(required = true)
    @NotBlank(message = "O nome do produto não pode estar em branco")
    @NotNull(message = "O nome do produto não pode ser nulo")
    private String nomeProduto;

    @JsonProperty(required = true)
    @NotBlank(message = "A descrição do produto não pode estar em branco")
    @NotNull(message = "A descrição do produto não pode ser nula")
    private String descricaoProduto;

    @JsonProperty(required = true)
    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private Double precoProduto;

    @JsonProperty(required = true)
    @NotNull(message = "O status deve ser informado")
    private Boolean ativo;

}
