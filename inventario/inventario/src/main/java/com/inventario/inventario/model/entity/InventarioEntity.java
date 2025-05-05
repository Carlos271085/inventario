package com.inventario.inventario.model.entity;

import java.sql.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@EntityScan
@Data
public class InventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column (name = "stockDisponible")
    private int stockDisponible;

    @Column (name = "ubicacionBodega")
    private String ubicacionBodega;

    @Column (name = "fechaUltimaActualizacion")
    private Date fechaUltimaActualizacion;
}
