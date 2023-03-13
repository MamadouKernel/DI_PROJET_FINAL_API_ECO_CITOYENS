package com.dibootcampfinal.apiecocitoyens.repository;


import com.dibootcampfinal.apiecocitoyens.models.ProRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRoleRepository extends JpaRepository<ProRoleEntity, Integer> {
}
