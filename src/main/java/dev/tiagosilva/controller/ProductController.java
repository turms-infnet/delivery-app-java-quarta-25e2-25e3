package dev.tiagosilva.controller;

import dev.tiagosilva.business.ProductBusinessHandler;
import dev.tiagosilva.dto.ProductRequestDTO;
import dev.tiagosilva.dto.ProductResponseDTO;

import java.util.List;

public class ProductController {
    public ProductBusinessHandler productBusinessHandler = new ProductBusinessHandler();

    public List<ProductResponseDTO> get() {
        return productBusinessHandler.get();
    }
    public ProductResponseDTO get(Long id) {
        return productBusinessHandler.get(id);
    }
    public boolean create(ProductRequestDTO productRequestDTO) {
        return productBusinessHandler.create(productRequestDTO);
    }
}
