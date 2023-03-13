package com.dibootcampfinal.apiecocitoyens.services;


import com.dibootcampfinal.apiecocitoyens.models.ProSitedecolletteEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProSitedecolletteRepository;
import com.dibootcampfinal.apiecocitoyens.services.ProSitedecolletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProSitedecolletteServiceImpl implements ProSitedecolletteService {

    @Autowired
    private ProSitedecolletteRepository siteRepository;

    @Override
    public List<ProSitedecolletteEntity> getAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public ProSitedecolletteEntity getSiteById(int id) {
        Optional<ProSitedecolletteEntity> optionalSite = siteRepository.findById(id);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        throw new IllegalArgumentException("Invalid site id: " + id);
    }

    @Override
    public ProSitedecolletteEntity createSite(ProSitedecolletteEntity site) {
        return siteRepository.save(site);
    }

    @Override
    public ProSitedecolletteEntity updateSite(int id, ProSitedecolletteEntity site) {
        Optional<ProSitedecolletteEntity> optionalSite = siteRepository.findById(id);
        if (optionalSite.isPresent()) {
            ProSitedecolletteEntity existingSite = optionalSite.get();
            existingSite.setNomdusite(site.getNomdusite());
            existingSite.setEmplacement(site.getEmplacement());
            existingSite.setFrequencedecollecte(site.getFrequencedecollecte());
            existingSite.setTypededechets(site.getTypededechets());
            return siteRepository.save(existingSite);
        }
        throw new IllegalArgumentException("Invalid site id: " + id);
    }

    @Override
    public void deleteSite(int id) {
        Optional<ProSitedecolletteEntity> optionalSite = siteRepository.findById(id);
        if (optionalSite.isPresent()) {
            siteRepository.delete(optionalSite.get());
        } else {
            throw new IllegalArgumentException("Invalid site id: " + id);
        }
    }
}
