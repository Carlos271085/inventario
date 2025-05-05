package com.inventario.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.inventario.model.Inventario;
import com.inventario.inventario.service.InventarioService;

@RestController
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @PostMapping("/crearInventario")
    //ResponseEntity <-- responder según acción o resultado
    // 404 --> no se encuentra el recurso
    // 200 --> ok

    public ResponseEntity<String> obtenerInventario(@RequestBody Inventario inventario){
        return ResponseEntity.ok(inventarioService.crearInventario(inventario));

    }

    @GetMapping("/obtenerInventario/{idProducto}")
    public ResponseEntity<Inventario> obtenerInventario(@PathVariable int idProducto){
        Inventario inventario = inventarioService.obtenerInventario(idProducto);
        if (inventario != null){
            return ResponseEntity.ok(inventario);
        }
        return ResponseEntity.notFound().build();
    }
    
}
