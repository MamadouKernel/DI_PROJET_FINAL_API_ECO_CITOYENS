package com.dibootcampfinal.apiecocitoyens.controllers;

import com.dibootcampfinal.apiecocitoyens.models.ProUtilisateurEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro-utilisateurs")
public class ProUtilisateurController {

    @Autowired
    private ProUtilisateurService proUtilisateurService;

    @GetMapping
    public ResponseEntity<List<ProUtilisateurEntity>> getAllUtilisateurs() {
        List<ProUtilisateurEntity> utilisateurs = proUtilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProUtilisateurEntity> getUtilisateurById(@PathVariable("id") int id) {
        ProUtilisateurEntity utilisateur = proUtilisateurService.getUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProUtilisateurEntity> createUtilisateur(@RequestBody ProUtilisateurEntity utilisateur) {
        ProUtilisateurEntity createdUtilisateur = proUtilisateurService.createUtilisateur(utilisateur);
        return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProUtilisateurEntity> updateUtilisateur(@PathVariable("id") int id, @RequestBody ProUtilisateurEntity updatedUtilisateur) {
        ProUtilisateurEntity utilisateur = proUtilisateurService.updateUtilisateur(id, updatedUtilisateur);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable("id") int id) {
        proUtilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
