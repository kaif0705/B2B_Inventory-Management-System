package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
@Getter
public class DuplicateSkuException extends RuntimeException {
    private final String sku;
    private final Long existingProductId;

    public DuplicateSkuException(String sku, Long existingProductId) {
        super(String.format("Product with SKU '%s' already exists.", sku));
        this.sku = sku;
        this.existingProductId = existingProductId;
    }
}
