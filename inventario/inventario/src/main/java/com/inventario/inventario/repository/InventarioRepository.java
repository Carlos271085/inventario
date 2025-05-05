package com.inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.inventario.model.entity.InventarioEntity;

@Repository
public interface InventarioRepository  extends JpaRepository<InventarioEntity, Integer>{

    InventarioEntity findBystockDisponible(int stockDisponible);
    Boolean exitsBystockDisponible(int stockDisponible);
    void deleteByStockDisponible(int stockDisponible);

    
}
