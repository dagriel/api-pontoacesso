package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriausuario){
        return categoriaUsuarioService.saveCategoriaUsuario(categoriausuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriaUsuarioList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        return  ResponseEntity.ok(categoriaUsuarioService.getById(idCategoriaUsuario).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriausuario){
        return categoriaUsuarioService.updateCategoriaUsuario(categoriausuario);
    }

    @DeleteMapping("/{idCategoriaUsuario}")
    public ResponseEntity deleteByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        try {
            categoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();
    }

}
