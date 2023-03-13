package com.dibootcampfinal.apiecocitoyens.repository;


import com.dibootcampfinal.apiecocitoyens.models.ProDechetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProDechetsRepository extends JpaRepository<ProDechetsEntity, Integer> {
}
