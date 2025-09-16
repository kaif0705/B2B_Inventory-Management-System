package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Repositories;

import com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
