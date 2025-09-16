package com.Inventory_Management_System_B2B_SaaS.Inventory_Management_System_B2B_SaaS.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "warehouses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false) // Foreign key to companies table
    private Company company;

    public Warehouse(Long id, String mainWarehouse) {
        this.id = id;
        this.name = mainWarehouse;
    }
}
