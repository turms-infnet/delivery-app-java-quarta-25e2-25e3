package dev.tiagosilva.business;

import dev.tiagosilva.dto.ProductRequestDTO;
import dev.tiagosilva.dto.ProductResponseDTO;
import dev.tiagosilva.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductBusinessHandler {
    public ProductModel productModel;

    public List<ProductResponseDTO> get() {
        List<ProductResponseDTO> productsResponseDTO = new ArrayList<>();

        try {
            productModel = new ProductModel();
            List<ProductModel> results = productModel.list();
            if (!results.isEmpty()) {
                results.forEach(product -> {
                    productsResponseDTO.add(ProductResponseDTO.modelToDto(product));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productsResponseDTO;
    }

    public ProductResponseDTO get(Long id) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        try {
            productModel = new ProductModel();
            ProductModel result = productModel.find(id);

            if (result != null) {
                productResponseDTO = ProductResponseDTO.modelToDto(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productResponseDTO;
    }

    public boolean create(ProductRequestDTO productRequestDTO) {
        try {
            productModel = new ProductModel();
            ProductModel result = productModel.find("name", productRequestDTO.getName());
            if (result == null || result.getName() == null) {
                productModel.setName(productRequestDTO.getName());
                productModel.setPrice(productRequestDTO.getPrice());
                productModel.save();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}