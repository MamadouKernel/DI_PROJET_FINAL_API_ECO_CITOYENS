package com.dibootcampfinal.apiecocitoyens.controllers;

import com.dibootcampfinal.apiecocitoyens.models.ProAlerteEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProAlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proalertes")
public class ProAlerteController {

    @Autowired
    private ProAlerteService proAlerteService;

    @GetMapping
    public ResponseEntity<Page<ProAlerteEntity>> getAllProAlertes(Pageable pageable) {
        Page<ProAlerteEntity> proAlertes = proAlerteService.findAll(pageable);
        return new ResponseEntity<>(proAlertes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProAlerteEntity> createProAlerte(@RequestBody ProAlerteEntity proAlerteEntity) {
        ProAlerteEntity savedProAlerte = proAlerteService.save(proAlerteEntity);
        return new ResponseEntity<>(savedProAlerte, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProAlerteEntity> getProAlerteById(@PathVariable int id) {
        ProAlerteEntity proAlerte = proAlerteService.findById(id);
        if (proAlerte == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proAlerte, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProAlerteEntity> updateProAlerte(@PathVariable int id, @RequestBody ProAlerteEntity proAlerteEntity) {
        ProAlerteEntity proAlerte = proAlerteService.findById(id);
        if (proAlerte == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        proAlerte.setIdalert(proAlerteEntity.getIdalert());
        proAlerte.setDateheurealerte(proAlerteEntity.getDateheurealerte());
        proAlerte.setTypealerte(proAlerteEntity.getTypealerte());
        proAlerte.setDescriptionalerte(proAlerteEntity.getDescriptionalerte());
        proAlerte.setProSitedecolletteByIdsite(proAlerteEntity.getProSitedecolletteByIdsite());

        ProAlerteEntity updatedProAlerte = proAlerteService.update(proAlerte);
        return new ResponseEntity<>(updatedProAlerte, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProAlerte(@PathVariable int id) {
        proAlerteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
