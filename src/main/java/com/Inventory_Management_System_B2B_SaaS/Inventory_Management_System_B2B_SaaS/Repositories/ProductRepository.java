package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Repositories;

import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}
