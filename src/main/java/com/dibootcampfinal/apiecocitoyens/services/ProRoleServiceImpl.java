package com.dibootcampfinal.apiecocitoyens.services;

import com.dibootcampfinal.apiecocitoyens.models.ProRoleEntity;
import com.dibootcampfinal.apiecocitoyens.repository.ProRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProRoleServiceImpl implements ProRoleService {

    @Autowired
    private ProRoleRepository proRoleRepository;

    @Override
    public ProRoleEntity createProRole(ProRoleEntity proRole) {
        return proRoleRepository.save(proRole);
    }

    @Override
    public Optional<ProRoleEntity> getProRoleById(int id) {
        return Optional.ofNullable(proRoleRepository.findById(id).orElse(null));
    }

    @Override
    public ProRoleEntity updateProRole(int id, ProRoleEntity proRole) {
        ProRoleEntity existingProRole = proRoleRepository.findById(id).orElse(null);
        if (existingProRole == null) {
            return null;
        }
        existingProRole.setLibelle(proRole.getLibelle());
        return proRoleRepository.save(existingProRole);
    }

    @Override
    public void deleteProRole(int id) {
        proRoleRepository.deleteById(id);
    }

    @Override
    public List<ProRoleEntity> getAllProRoles() {
        return proRoleRepository.findAll();
    }
}
