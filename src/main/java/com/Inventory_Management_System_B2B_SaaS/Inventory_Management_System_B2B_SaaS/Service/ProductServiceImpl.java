package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Service;

import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.DTOs.ProductCreateRequestDTO;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Exception.DuplicateSkuException;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Exception.ResourceNotFoundException;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.Inventory;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.Product;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.Warehouse;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Repositories.InventoryRepository;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Repositories.ProductRepository;
import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Transactional
    public Product createProduct(ProductCreateRequestDTO requestDTO) {
        if (productRepository.findBySku(requestDTO.getSku()).isPresent()) {
            throw new DuplicateSkuException(requestDTO.getSku(),
                    productRepository.findBySku(requestDTO.getSku()).get().getId());
        }
        Warehouse warehouse = warehouseRepository.findById(requestDTO.getWarehouseId())
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", requestDTO.getWarehouseId()));

        Product product = new Product();
        product.setName(requestDTO.getName());
        product.setSku(requestDTO.getSku());
        product.setPrice(requestDTO.getPrice());

        productRepository.save(product);

        Inventory inventory = new Inventory(
                product,
                warehouse,
                requestDTO.getInitialQuantity()
        );

        inventoryRepository.save(inventory);

        return product;
    }
}
