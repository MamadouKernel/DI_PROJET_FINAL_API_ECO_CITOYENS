package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProAlerteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProAlerteService {

    ProAlerteEntity save(ProAlerteEntity proAlerteEntity);

    Page<ProAlerteEntity> findAll(Pageable pageable);

    void deleteById(int id);

    // Recherche par ID
    ProAlerteEntity findById(int id);

    // Modification
    ProAlerteEntity update(ProAlerteEntity proAlerteEntity);
}
