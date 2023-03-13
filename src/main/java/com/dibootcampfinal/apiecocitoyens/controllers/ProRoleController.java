package com.dibootcampfinal.apiecocitoyens.controllers;

import com.dibootcampfinal.apiecocitoyens.models.ProRoleEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pro-roles")
public class ProRoleController {

    @Autowired
    private ProRoleService proRoleService;

    @GetMapping
    public List<ProRoleEntity> getAllProRoles() {
        return proRoleService.getAllProRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProRoleEntity> getProRoleById(@PathVariable("id") int id) {
        Optional<ProRoleEntity> proRole = proRoleService.getProRoleById(id);
        return proRole.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<ProRoleEntity> createProRole(@RequestBody ProRoleEntity proRole) {
        ProRoleEntity createdProRole = proRoleService.createProRole(proRole);
        return ResponseEntity.created(URI.create("/pro-roles/" + createdProRole.getIdrole()))
                .body(createdProRole);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProRoleEntity> updateProRole(@PathVariable("id") int id, @RequestBody ProRoleEntity proRole) {
        ProRoleEntity updatedProRole = proRoleService.updateProRole(id, proRole);
        if (updatedProRole == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProRole);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProRole(@PathVariable("id") int id) {
        proRoleService.deleteProRole(id);
        return ResponseEntity.noContent().build();
    }
}
