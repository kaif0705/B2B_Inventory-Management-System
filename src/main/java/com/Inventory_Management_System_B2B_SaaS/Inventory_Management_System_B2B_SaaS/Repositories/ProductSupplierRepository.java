package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Repositories;

import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Long> {
    List<ProductSupplier> findByProductId(Long id);

    Optional<Object> findByProductIdAndSupplierId(Long id, Long id1);
}

