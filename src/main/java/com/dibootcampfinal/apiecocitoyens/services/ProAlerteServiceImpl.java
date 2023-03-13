package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProAlerteEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProAlerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProAlerteServiceImpl implements ProAlerteService {

    @Autowired
    private ProAlerteRepository proAlerteRepository;

    @Override
    public ProAlerteEntity save(ProAlerteEntity proAlerteEntity) {
        return proAlerteRepository.save(proAlerteEntity);
    }

    @Override
    public Page<ProAlerteEntity> findAll(Pageable pageable) {
        return proAlerteRepository.findAll(pageable);
    }

    @Override
    public void deleteById(int id) {
        proAlerteRepository.deleteById(id);
    }

    @Override
    public ProAlerteEntity findById(int id) {
        return proAlerteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProAlerteEntity not found"));
    }

    @Override
    public ProAlerteEntity update(ProAlerteEntity proAlerteEntity) {
        ProAlerteEntity proAlerte = proAlerteRepository.findById(proAlerteEntity.getIdalert())
                .orElseThrow(() -> new RuntimeException("ProAlerteEntity not found"));
        proAlerte.setDateheurealerte(proAlerteEntity.getDateheurealerte());
        proAlerte.setTypealerte(proAlerteEntity.getTypealerte());
        proAlerte.setDescriptionalerte(proAlerteEntity.getDescriptionalerte());
        proAlerte.setProSitedecolletteByIdsite(proAlerteEntity.getProSitedecolletteByIdsite());
        return proAlerteRepository.save(proAlerte);
    }
}
