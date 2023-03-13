package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProDechetsEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProDechetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProDechetsServiceImpl implements ProDechetsService {

    @Autowired
    private ProDechetsRepository proDechetsRepository;

    @Override
    public ProDechetsEntity save(ProDechetsEntity proDechetsEntity) {
        if (proDechetsEntity == null) {
            throw new IllegalArgumentException("ProDechetsEntity ne peut pas être null");
        }
        return proDechetsRepository.save(proDechetsEntity);
    }



    @Override
    public Page<ProDechetsEntity> findAll(Pageable pageable) {
        return proDechetsRepository.findAll(pageable);
    }

    @Override
    public void deleteById(int id) {
        proDechetsRepository.deleteById(id);
    }

    @Override
    public ProDechetsEntity findById(int id) {
        return proDechetsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProDechetsEntity avec l'ID " + id + " est introuvable"));
    }

    @Override
    public ProDechetsEntity update(ProDechetsEntity proDechetsEntity) {
        if (proDechetsEntity == null) {
            throw new IllegalArgumentException("ProDechetsEntity ne peut pas être null");
        }
        ProDechetsEntity existingProDechetsEntity = findById(proDechetsEntity.getIddechet());
        existingProDechetsEntity.setNom(proDechetsEntity.getNom());
        existingProDechetsEntity.setDescription(proDechetsEntity.getDescription());
        existingProDechetsEntity.setClassification(proDechetsEntity.getClassification());
        return proDechetsRepository.save(existingProDechetsEntity);
    }
}
