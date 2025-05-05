package com.inventario.inventario.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Inventario {

    private int idProducto;
    private int stockDisponible;
    private String ubicacionBodega;
    private Date fechaUltimaActualizacion;



}
