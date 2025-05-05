package com.inventario.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.inventario.model.Inventario;
import com.inventario.inventario.model.entity.InventarioEntity;
import com.inventario.inventario.repository.InventarioRepository;

@Service

public class InventarioService {
    @Autowired
    private InventarioRepository inventariorepository;

    public String crearInventario(Inventario inv) {

        try {
            Boolean estado = inventariorepository.existsById(inv.getIdProducto());
            if (!estado) {
                InventarioEntity inventarioNuevo = new InventarioEntity();
                inventarioNuevo.setIdProducto(inv.getIdProducto());
                inventarioNuevo.setStockDisponible(inv.getStockDisponible());
                inventarioNuevo.setUbicacionBodega(inv.getUbicacionBodega());
                inventarioNuevo.setFechaUltimaActualizacion(inv.getFechaUltimaActualizacion());
                inventariorepository.save(inventarioNuevo);
                return "Inventario creado correctamente";

                
            }
            return "El inventario ya existe";
            
        } catch (Exception e) {
            return "Error al crear el inventario";
        }


    }

    public Inventario obtenerInventario(int idProducto){

        try {
            InventarioEntity inventario = inventariorepository.findBystockDisponible(idProducto);
            if (inventario != null){
                Inventario inv = new Inventario(
                    inventario.getIdProducto(),
                    inventario.getStockDisponible(),
                    inventario.getUbicacionBodega(),
                    inventario.getFechaUltimaActualizacion()
                );
                return inv;
            }
            return null;
            
        } catch (Exception e) {
            return null;
        }


    }


}
