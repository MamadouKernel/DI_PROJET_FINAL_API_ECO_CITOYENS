package com.dibootcampfinal.apiecocitoyens.controllers;


import com.dibootcampfinal.apiecocitoyens.models.ProSitedecolletteEntity;
import com.dibootcampfinal.apiecocitoyens.services.ProSitedecolletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sites")
public class ProSitedecolletteController {

    @Autowired
    private ProSitedecolletteService siteService;

    @GetMapping
    public ResponseEntity<List<ProSitedecolletteEntity>> getAllSites() {
        List<ProSitedecolletteEntity> sites = siteService.getAllSites();
        return new ResponseEntity<>(sites, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProSitedecolletteEntity> getSiteById(@PathVariable("id") int id) {
        ProSitedecolletteEntity site = siteService.getSiteById(id);
        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProSitedecolletteEntity> createSite(@RequestBody ProSitedecolletteEntity site) {
        ProSitedecolletteEntity createdSite = siteService.createSite(site);
        return new ResponseEntity<>(createdSite, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProSitedecolletteEntity> updateSite(@PathVariable("id") int id, @RequestBody ProSitedecolletteEntity site) {
        ProSitedecolletteEntity updatedSite = siteService.updateSite(id, site);
        return new ResponseEntity<>(updatedSite, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSite(@PathVariable("id") int id) {
        siteService.deleteSite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
