package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProTraitementEntity;

import java.util.List;

public interface ProTraitementService {
    List<ProTraitementEntity> getAllTraitements();

    ProTraitementEntity getTraitementById(int id);

    ProTraitementEntity createTraitement(ProTraitementEntity traitement);

    ProTraitementEntity updateTraitement(int id, ProTraitementEntity updatedTraitement);

    void deleteTraitement(int id);
}
