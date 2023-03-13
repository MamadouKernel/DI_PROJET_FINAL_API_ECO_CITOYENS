package com.dibootcampfinal.apiecocitoyens.services;


import com.dibootcampfinal.apiecocitoyens.models.ProRoleEntity;

import java.util.List;
import java.util.Optional;

public interface ProRoleService {
    List<ProRoleEntity> getAllProRoles();

    Optional<ProRoleEntity> getProRoleById(int id);

    ProRoleEntity createProRole(ProRoleEntity proRole);

    ProRoleEntity updateProRole(int id, ProRoleEntity proRole);

    void deleteProRole(int id);
}
