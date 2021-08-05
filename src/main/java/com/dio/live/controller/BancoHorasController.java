package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancohorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancohoras){
        return bancohorasService.saveBancoHoras(bancohoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList(){
        return bancohorasService.findAll();
    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        return  ResponseEntity.ok(bancohorasService.getById(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancohoras){
        return bancohorasService.updateBancoHoras(bancohoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity deleteByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        try {
            bancohorasService.deleteBancoHoras(idBancoHoras);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();
    }

}
