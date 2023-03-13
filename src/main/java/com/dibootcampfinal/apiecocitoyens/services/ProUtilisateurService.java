package com.dibootcampfinal.apiecocitoyens.services;


import com.dibootcampfinal.apiecocitoyens.models.ProUtilisateurEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProUtilisateurService {
    List<ProUtilisateurEntity> getAllUtilisateurs();

    ProUtilisateurEntity getUtilisateurById(int id);

    ProUtilisateurEntity createUtilisateur(ProUtilisateurEntity utilisateur);

    ProUtilisateurEntity updateUtilisateur(int id, ProUtilisateurEntity updatedUtilisateur);

    void deleteUtilisateur(int id);
}
