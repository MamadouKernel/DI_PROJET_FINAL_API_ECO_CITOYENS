package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProPlanificationdelacolletteEntity;

import java.util.List;

public interface ProPlanificationdelacolletteService {

    ProPlanificationdelacolletteEntity createProPlanificationdelacollette(ProPlanificationdelacolletteEntity proPlanificationdelacollette);

    ProPlanificationdelacolletteEntity updateProPlanificationdelacollette(Integer id, ProPlanificationdelacolletteEntity proPlanificationdelacollette);

    void deleteProPlanificationdelacollette(Integer id);

    ProPlanificationdelacolletteEntity getProPlanificationdelacolletteById(Integer id);

    List<ProPlanificationdelacolletteEntity> getAllProPlanificationdelacollettes();

}
