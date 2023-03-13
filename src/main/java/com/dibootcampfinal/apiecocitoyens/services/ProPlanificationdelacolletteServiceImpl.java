package com.dibootcampfinal.apiecocitoyens.services.impl;


import com.dibootcampfinal.apiecocitoyens.models.ProPlanificationdelacolletteEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProPlanificationdelacolletteRepository;
import com.dibootcampfinal.apiecocitoyens.services.ProPlanificationdelacolletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProPlanificationdelacolletteServiceImpl implements ProPlanificationdelacolletteService {

    private ProPlanificationdelacolletteRepository proPlanificationdelacolletteRepository;

    @Autowired
    public ProPlanificationdelacolletteServiceImpl(ProPlanificationdelacolletteRepository proPlanificationdelacolletteRepository) {
        this.proPlanificationdelacolletteRepository = proPlanificationdelacolletteRepository;
    }

    @Override
    public ProPlanificationdelacolletteEntity createProPlanificationdelacollette(ProPlanificationdelacolletteEntity proPlanificationdelacollette) {
        // Vérifier que l'entité à créer ne possède pas d'ID
        if (proPlanificationdelacollette.getProSitedecolletteByIdsite() != null) {
            throw new IllegalArgumentException("La création d'une entité avec un ID existant n'est pas permise");
        }
        return proPlanificationdelacolletteRepository.save(proPlanificationdelacollette);
    }

    @Override
    public ProPlanificationdelacolletteEntity updateProPlanificationdelacollette(Integer id, ProPlanificationdelacolletteEntity proPlanificationdelacollette) {
        // Vérifier que l'entité à mettre à jour existe
        ProPlanificationdelacolletteEntity existingEntity = getProPlanificationdelacolletteById(id);
        if (existingEntity == null) {
            throw new IllegalArgumentException("L'entité à mettre à jour n'existe pas.");
        }
        // Vérifier que proPlanificationdelacollette n'est pas null
        if (proPlanificationdelacollette == null) {
            throw new IllegalArgumentException("L'entité à mettre à jour ne peut pas être null.");
        }
        // Vérifier que l'ID de l'entité à mettre à jour correspond à celui passé en paramètre
        if (existingEntity.getIdplanification() != id) {
            throw new IllegalArgumentException("L'ID de l'entité à mettre à jour (" + proPlanificationdelacollette.getIdplanification() + ") ne correspond pas à celui passé en paramètre (" + id + ")");
        }
        return proPlanificationdelacolletteRepository.save(proPlanificationdelacollette);
    }

    @Override
    public void deleteProPlanificationdelacollette(Integer id) {
        // Vérifier que l'entité à supprimer existe
        ProPlanificationdelacolletteEntity existingEntity = getProPlanificationdelacolletteById(id);
        proPlanificationdelacolletteRepository.delete(existingEntity);
    }

    @Override
    public ProPlanificationdelacolletteEntity getProPlanificationdelacolletteById(Integer id) {
        return proPlanificationdelacolletteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entité non trouvée avec l'ID : " + id));
    }

    @Override
    public List<ProPlanificationdelacolletteEntity> getAllProPlanificationdelacollettes() {
        return proPlanificationdelacolletteRepository.findAll();
    }
}
