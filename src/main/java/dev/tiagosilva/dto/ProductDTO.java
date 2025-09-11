package dev.tiagosilva.dto;

import dev.tiagosilva.controller.Controller;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO extends Controller<ProductDTO> {
    private Long id;
    private String name;
    private Float price;

    public ProductDTO(String name, Float price) {
        this.name = name;
        this.price = price;
    }
}
