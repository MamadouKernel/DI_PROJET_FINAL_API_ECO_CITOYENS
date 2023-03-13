package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProUtilisateurEntity;;
import com.dibootcampfinal.apiecocitoyens.repository.ProUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProUtilisateurServiceImpl implements ProUtilisateurService {

    private final ProUtilisateurRepository proUtilisateurRepository;

    @Autowired
    public ProUtilisateurServiceImpl(ProUtilisateurRepository proUtilisateurRepository) {
        this.proUtilisateurRepository = proUtilisateurRepository;
    }

    @Override
    public List<ProUtilisateurEntity> getAllUtilisateurs() {
        return proUtilisateurRepository.findAll();
    }

    @Override
    public ProUtilisateurEntity getUtilisateurById(int id) {
        Optional<ProUtilisateurEntity> optionalProUtilisateur = proUtilisateurRepository.findById(id);
        return optionalProUtilisateur.orElse(null);
    }

    @Override
    public ProUtilisateurEntity createUtilisateur(ProUtilisateurEntity utilisateur) {
        return proUtilisateurRepository.save(utilisateur);
    }

    @Override
    public ProUtilisateurEntity updateUtilisateur(int id, ProUtilisateurEntity updatedUtilisateur) {
        Optional<ProUtilisateurEntity> optionalProUtilisateur = proUtilisateurRepository.findById(id);
        if (optionalProUtilisateur.isPresent()) {
            ProUtilisateurEntity proUtilisateur = optionalProUtilisateur.get();
            proUtilisateur.setNom(updatedUtilisateur.getNom());
            proUtilisateur.setPrenom(updatedUtilisateur.getPrenom());
            proUtilisateur.setEmail(updatedUtilisateur.getEmail());
            proUtilisateur.setNomutilisateur(updatedUtilisateur.getNomutilisateur());
            proUtilisateur.setMotdepasse(updatedUtilisateur.getMotdepasse());
            return proUtilisateurRepository.save(proUtilisateur);
        }
        return null;
    }

    @Override
    public void deleteUtilisateur(int id) {
        proUtilisateurRepository.deleteById(id);
    }

}
