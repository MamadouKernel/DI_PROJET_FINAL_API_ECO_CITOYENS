package com.dibootcampfinal.apiecocitoyens.repository;


import com.dibootcampfinal.apiecocitoyens.models.ProSitedecolletteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProSitedecolletteRepository extends JpaRepository<ProSitedecolletteEntity, Integer> {
}
