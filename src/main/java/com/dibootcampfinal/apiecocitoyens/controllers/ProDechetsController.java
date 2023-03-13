package com.dibootcampfinal.apiecocitoyens.controllers;

import com.dibootcampfinal.apiecocitoyens.models.ProDechetsEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProDechetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/prodechets")
public class ProDechetsController {

    private final ProDechetsService proDechetsService;

    @Autowired
    public ProDechetsController(ProDechetsService proDechetsService) {
        this.proDechetsService = proDechetsService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProDechetsEntity> createProDechets(@Valid @RequestBody ProDechetsEntity proDechets) {
        ProDechetsEntity savedProDechets = proDechetsService.save(proDechets);
        return new ResponseEntity<>(savedProDechets, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProDechetsEntity>> getAllProDechets(Pageable pageable) {
        Page<ProDechetsEntity> proDechetsPage = proDechetsService.findAll(pageable);
        List<ProDechetsEntity> proDechetsList = proDechetsPage.getContent();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(proDechetsPage.getTotalElements()));
        headers.add("X-Total-Pages", String.valueOf(proDechetsPage.getTotalPages()));
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, X-Total-Pages");
        return new ResponseEntity<>(proDechetsList, headers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProDechetsEntity> getProDechetsById(@PathVariable int id) {
        ProDechetsEntity proDechets = proDechetsService.findById(id);
        if (proDechets == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proDechets, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProDechetsEntity> updateProDechets(@PathVariable int id, @Valid @RequestBody ProDechetsEntity proDechets) {
        if (proDechetsService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        proDechets.setIddechet(id);
        ProDechetsEntity updatedProDechets = proDechetsService.update(proDechets);
        return new ResponseEntity<>(updatedProDechets, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProDechets(@PathVariable int id) {
        ProDechetsEntity proDechets = proDechetsService.findById(id);
        if (proDechets == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        proDechetsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
