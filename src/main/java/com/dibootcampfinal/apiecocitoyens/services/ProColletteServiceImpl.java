package com.dibootcampfinal.apiecocitoyens.services;
import com.dibootcampfinal.apiecocitoyens.models.ProColletteEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProColletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProColletteServiceImpl implements ProColletteService {

    @Autowired
    private ProColletteRepository proColletteRepository;

    @Override
    public ProColletteEntity save(ProColletteEntity proColletteEntity) {
        // Vérification que l'id est null pour éviter la modification d'un enregistrement existant
        if (proColletteEntity.getIdcollette() != 0) {
            throw new IllegalArgumentException("L'enregistrement ne doit pas avoir d'ID.");
        }
        return proColletteRepository.save(proColletteEntity);
    }

    @Override
    public Page<ProColletteEntity> findAll(Pageable pageable) {
        return proColletteRepository.findAll(pageable);
    }

    @Override
    public void deleteById(int id) {
        Optional<ProColletteEntity> proColletteOptional = proColletteRepository.findById(id);
        if (proColletteOptional.isEmpty()) {
            throw new RuntimeException("La collecte avec l'ID " + id + " n'existe pas.");
        }
        proColletteRepository.deleteById(id);
    }

    @Override
    public ProColletteEntity findById(int id) {
        Optional<ProColletteEntity> proColletteOptional = proColletteRepository.findById(id);
        if (proColletteOptional.isEmpty()) {
            throw new RuntimeException("La collecte avec l'ID " + id + " n'existe pas.");
        }
        return proColletteOptional.get();
    }

    @Override
    public ProColletteEntity update(ProColletteEntity proColletteEntity) {
        // Vérification que l'id n'est pas null pour éviter l'ajout d'un nouvel enregistrement
        if (proColletteEntity.getIdcollette() == 0) {
            throw new IllegalArgumentException("L'enregistrement doit avoir un ID.");
        }
        Optional<ProColletteEntity> proColletteOptional = proColletteRepository.findById(proColletteEntity.getIdcollette());
        if (proColletteOptional.isEmpty()) {
            throw new RuntimeException("La collecte avec l'ID " + proColletteEntity.getIdcollette() + " n'existe pas.");
        }
        return proColletteRepository.save(proColletteEntity);
    }
}
