package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProSitedecolletteEntity;

import java.util.List;

public interface ProSitedecolletteService {
    List<ProSitedecolletteEntity> getAllSites();
    ProSitedecolletteEntity getSiteById(int id);
    ProSitedecolletteEntity createSite(ProSitedecolletteEntity site);
    ProSitedecolletteEntity updateSite(int id, ProSitedecolletteEntity site);
    void deleteSite(int id);
}
