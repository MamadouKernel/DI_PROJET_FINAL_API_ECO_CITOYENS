package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProColletteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProColletteService {

    ProColletteEntity save(ProColletteEntity proColletteEntity);

    Page<ProColletteEntity> findAll(Pageable pageable);

    void deleteById(int id);

    // Recherche par ID
    ProColletteEntity findById(int id);

    // Modification
    ProColletteEntity update(ProColletteEntity proColletteEntity);
}
