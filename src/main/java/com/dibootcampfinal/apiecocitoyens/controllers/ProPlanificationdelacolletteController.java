package com.dibootcampfinal.apiecocitoyens.controllers;

import com.dibootcampfinal.apiecocitoyens.models.ProPlanificationdelacolletteEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProPlanificationdelacolletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/proPlanificationdelacollettes")
public class ProPlanificationdelacolletteController {

    private final ProPlanificationdelacolletteService proPlanificationdelacolletteService;

    @Autowired
    public ProPlanificationdelacolletteController(ProPlanificationdelacolletteService proPlanificationdelacolletteService) {
        this.proPlanificationdelacolletteService = proPlanificationdelacolletteService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProPlanificationdelacolletteEntity> createProPlanificationdelacollette(@Valid @RequestBody ProPlanificationdelacolletteEntity proPlanificationdelacollette) {
        ProPlanificationdelacolletteEntity createdEntity = proPlanificationdelacolletteService.createProPlanificationdelacollette(proPlanificationdelacollette);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProPlanificationdelacolletteEntity> updateProPlanificationdelacollette(@PathVariable Integer id, @Valid @RequestBody ProPlanificationdelacolletteEntity proPlanificationdelacollette) {
        ProPlanificationdelacolletteEntity updatedEntity = proPlanificationdelacolletteService.updateProPlanificationdelacollette(id, proPlanificationdelacollette);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProPlanificationdelacollette(@PathVariable Integer id) {
        proPlanificationdelacolletteService.deleteProPlanificationdelacollette(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProPlanificationdelacolletteEntity> getProPlanificationdelacolletteById(@PathVariable Integer id) {
        ProPlanificationdelacolletteEntity entity = proPlanificationdelacolletteService.getProPlanificationdelacolletteById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProPlanificationdelacolletteEntity>> getAllProPlanificationdelacollettes() {
        List<ProPlanificationdelacolletteEntity> entities = proPlanificationdelacolletteService.getAllProPlanificationdelacollettes();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
