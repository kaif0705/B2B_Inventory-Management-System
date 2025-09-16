package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String sku;
    private BigDecimal price;
    private String message;
}
