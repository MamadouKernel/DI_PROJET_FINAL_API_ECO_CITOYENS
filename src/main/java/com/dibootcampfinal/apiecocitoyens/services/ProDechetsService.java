package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProDechetsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProDechetsService {

    ProDechetsEntity save(ProDechetsEntity proDechetsEntity);

    Page<ProDechetsEntity> findAll(Pageable pageable);

    void deleteById(int id);

    // Recherche par ID
    ProDechetsEntity findById(int id);

    // Modification
    ProDechetsEntity update(ProDechetsEntity proDechetsEntity);
}
