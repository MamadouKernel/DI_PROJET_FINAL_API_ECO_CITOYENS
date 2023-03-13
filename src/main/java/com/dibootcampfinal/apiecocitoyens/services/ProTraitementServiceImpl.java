package com.dibootcampfinal.apiecocitoyens.services;


import com.dibootcampfinal.apiecocitoyens.models.ProTraitementEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProTraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProTraitementServiceImpl implements ProTraitementService {

    private final ProTraitementRepository traitementRepository;

    @Autowired
    public ProTraitementServiceImpl(ProTraitementRepository traitementRepository) {
        this.traitementRepository = traitementRepository;
    }

    @Override
    public List<ProTraitementEntity> getAllTraitements() {
        return traitementRepository.findAll();
    }

    @Override
    public ProTraitementEntity getTraitementById(int id) {
        Optional<ProTraitementEntity> result = traitementRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Traitement introuvable pour l'id " + id);
        }
    }

    @Override
    public ProTraitementEntity createTraitement(ProTraitementEntity traitement) {
        return traitementRepository.save(traitement);
    }

    @Override
    public ProTraitementEntity updateTraitement(int id, ProTraitementEntity updatedTraitement) {
        Optional<ProTraitementEntity> result = traitementRepository.findById(id);
        if (result.isPresent()) {
            ProTraitementEntity traitement = result.get();
            traitement.setTypedetraitement(updatedTraitement.getTypedetraitement());
            traitement.setQuantitetraitee(updatedTraitement.getQuantitetraitee());
            traitement.setDateheuretraitement(updatedTraitement.getDateheuretraitement());
            traitement.setProColletteByIdcollette(updatedTraitement.getProColletteByIdcollette());
            return traitementRepository.save(traitement);
        } else {
            throw new RuntimeException("Traitement introuvable pour l'id " + id);
        }
    }

    @Override
    public void deleteTraitement(int id) {
        Optional<ProTraitementEntity> result = traitementRepository.findById(id);
        if (result.isPresent()) {
            traitementRepository.delete(result.get());
        } else {
            throw new RuntimeException("Traitement introuvable pour l'id " + id);
        }
    }
}
