package com.delivery.produto.mapstruct;

import com.delivery.produto.dto.ProductRequestDTO;
import com.delivery.produto.dto.ProductResponseDTO;
import com.delivery.produto.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mapping(target = "idProduto", ignore = true)
    ProductModel toModel(ProductRequestDTO productRequestDTO);

    @Mapping(target = "idProduto", ignore = true)
    void updateModel(ProductRequestDTO productRequestDTO, @MappingTarget ProductModel productModel);

    ProductResponseDTO  productResponseDTO(ProductModel productModel);

    List<ProductResponseDTO> productResponseDTOList(List<ProductModel> productModels);
}
