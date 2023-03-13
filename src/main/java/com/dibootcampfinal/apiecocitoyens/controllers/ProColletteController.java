package com.dibootcampfinal.apiecocitoyens.controllers;

import com.dibootcampfinal.apiecocitoyens.models.ProColletteEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProColletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pro-collettes")
public class ProColletteController {

    @Autowired
    private ProColletteService proColletteService;

    // Création d'une nouvelle collette
    @PostMapping("/create")
    public ResponseEntity<ProColletteEntity> create(@RequestBody ProColletteEntity proColletteEntity) {
        ProColletteEntity savedProColletteEntity = proColletteService.save(proColletteEntity);
        return new ResponseEntity<>(savedProColletteEntity, HttpStatus.CREATED);
    }

    // Récupération de toutes les collettes paginées
    @GetMapping
    public ResponseEntity<Page<ProColletteEntity>> findAll(Pageable pageable) {
        Page<ProColletteEntity> proColletteEntities = proColletteService.findAll(pageable);
        return new ResponseEntity<>(proColletteEntities, HttpStatus.OK);
    }

    // Récupération d'une collette par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProColletteEntity> findById(@PathVariable int id) {
        ProColletteEntity proColletteEntity = proColletteService.findById(id);
        if (proColletteEntity != null) {
            return new ResponseEntity<>(proColletteEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Modification d'une collette
    @PutMapping("/update/{id}")
    public ResponseEntity<ProColletteEntity> update(@PathVariable int id, @RequestBody ProColletteEntity proColletteEntity) {
        ProColletteEntity existingProColletteEntity = proColletteService.findById(id);
        if (existingProColletteEntity != null) {
            proColletteEntity.setIdcollette(id);
            ProColletteEntity updatedProColletteEntity = proColletteService.update(proColletteEntity);
            return new ResponseEntity<>(updatedProColletteEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Suppression d'une collette
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        ProColletteEntity existingProColletteEntity = proColletteService.findById(id);
        if (existingProColletteEntity != null) {
            proColletteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
