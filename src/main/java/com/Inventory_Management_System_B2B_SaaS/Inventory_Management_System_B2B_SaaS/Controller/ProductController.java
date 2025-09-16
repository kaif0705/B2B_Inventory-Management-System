package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Controller;

import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.DTOs.ProductCreateRequestDTO;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.DTOs.ProductResponseDTO;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.Product;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductCreateRequestDTO requestDTO) {
        Product createdProduct = productService.createProduct(requestDTO);

        ProductResponseDTO responseDTO = new ProductResponseDTO(
                createdProduct.getId(),
                createdProduct.getName(),
                createdProduct.getSku(),
                createdProduct.getPrice(),
                "Product created successfully"
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
