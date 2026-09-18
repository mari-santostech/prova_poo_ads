package com.trabalho_mariana.demo.controller;

import com.trabalho_mariana.demo.model.PadariaModel;
import com.trabalho_mariana.demo.sevice.PadariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/padaria")
public class PadariaController {

    @Autowired
    private PadariaService padariaService;

    @GetMapping
    public ResponseEntity<List<PadariaModel>> findAll(){
        List<PadariaModel> response = padariaService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PadariaModel> buscarPorId(@PathVariable Long id){
        PadariaModel response = padariaService.buscarPorId(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<PadariaModel> criarCliente(@RequestBody PadariaModel filmeModel){
        PadariaModel response = padariaService.criarCliente(filmeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        padariaService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PadariaModel> atualizar(@PathVariable Long id, @RequestBody PadariaModel padariaModel){
        PadariaModel response = padariaService.atualizar(id, padariaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
