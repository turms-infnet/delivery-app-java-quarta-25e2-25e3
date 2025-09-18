package dev.tiagosilva.dto;

import dev.tiagosilva.controller.Controller;
import dev.tiagosilva.model.ProductModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDTO {
    private Long id;
    private String name;
    private Float price;

    public ProductResponseDTO(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public ProductResponseDTO() {}

    public static ProductResponseDTO modelToDto(ProductModel productModel) {
        ProductResponseDTO item = new ProductResponseDTO();
        item.setId(productModel.getId());
        item.setName(productModel.getName());

        return item;
    }
}
