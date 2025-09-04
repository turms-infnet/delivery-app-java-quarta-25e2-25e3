package dev.tiagosilva.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private Float price;

    public ProductDTO(String name, Float price) {
        this.name = name;
        this.price = price;
    }
}
