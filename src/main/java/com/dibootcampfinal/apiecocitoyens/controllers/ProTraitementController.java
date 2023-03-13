package com.dibootcampfinal.apiecocitoyens.controllers;


import com.dibootcampfinal.apiecocitoyens.models.ProTraitementEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProTraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traitements")
public class ProTraitementController {

    @Autowired
    private ProTraitementService traitementService;

    @GetMapping("")
    public ResponseEntity<List<ProTraitementEntity>> getAllTraitements() {
        List<ProTraitementEntity> traitements = traitementService.getAllTraitements();
        return ResponseEntity.ok().body(traitements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProTraitementEntity> getTraitementById(@PathVariable int id) {
        ProTraitementEntity traitement = traitementService.getTraitementById(id);
        if (traitement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(traitement);
    }

    @PostMapping("/create")
    public ResponseEntity<ProTraitementEntity> createTraitement(@RequestBody ProTraitementEntity traitement) {
        ProTraitementEntity createdTraitement = traitementService.createTraitement(traitement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTraitement);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProTraitementEntity> updateTraitement(@PathVariable int id, @RequestBody ProTraitementEntity updatedTraitement) {
        ProTraitementEntity traitement = traitementService.updateTraitement(id, updatedTraitement);
        if (traitement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(traitement);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTraitement(@PathVariable int id) {
        traitementService.deleteTraitement(id);
        return ResponseEntity.noContent().build();
    }

}
