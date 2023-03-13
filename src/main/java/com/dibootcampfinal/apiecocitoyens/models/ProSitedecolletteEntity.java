package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pro_sitedecollette", schema = "public", catalog = "eco_citoyens")
public class ProSitedecolletteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsite", nullable = false)
    private int idsite;
    @Basic
    @Column(name = "nomdusite", nullable = false, length = 45)
    private String nomdusite;
    @Basic
    @Column(name = "emplacement", nullable = false, length = 45)
    private String emplacement;
    @Basic
    @Column(name = "typededechets", nullable = false, length = 45)
    private String typededechets;
    @Basic
    @Column(name = "frequencedecollecte", nullable = false, length = 45)
    private String frequencedecollecte;

    @OneToMany(mappedBy = "proSitedecolletteByIdsite")
    private Collection<ProAlerteEntity> proAlertesByIdsite;
    @OneToMany(mappedBy = "proSitedecolletteByIdsite")
    private Collection<ProDechetsEntity> proDechetsByIdsite;
    @OneToMany(mappedBy = "proSitedecolletteByIdsite")
    private Collection<ProPlanificationdelacolletteEntity> proPlanificationdelacollettesByIdsite;
    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", nullable = false)
    private ProUtilisateurEntity proUtilisateurByIdutilisateur;

    public int getIdsite() {
        return idsite;
    }

    public void setIdsite(int idsite) {
        this.idsite = idsite;
    }

    public String getNomdusite() {
        return nomdusite;
    }

    public void setNomdusite(String nomdusite) {
        this.nomdusite = nomdusite;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getTypededechets() {
        return typededechets;
    }

    public void setTypededechets(String typededechets) {
        this.typededechets = typededechets;
    }

    public String getFrequencedecollecte() {
        return frequencedecollecte;
    }

    public void setFrequencedecollecte(String frequencedecollecte) {
        this.frequencedecollecte = frequencedecollecte;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProSitedecolletteEntity that = (ProSitedecolletteEntity) o;
        return idsite == that.idsite && Objects.equals(nomdusite, that.nomdusite) && Objects.equals(emplacement, that.emplacement) && Objects.equals(typededechets, that.typededechets) && Objects.equals(frequencedecollecte, that.frequencedecollecte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idsite, nomdusite, emplacement, typededechets, frequencedecollecte);
    }

    public Collection<ProAlerteEntity> getProAlertesByIdsite() {
        return proAlertesByIdsite;
    }

    public void setProAlertesByIdsite(Collection<ProAlerteEntity> proAlertesByIdsite) {
        this.proAlertesByIdsite = proAlertesByIdsite;
    }

    public Collection<ProDechetsEntity> getProDechetsByIdsite() {
        return proDechetsByIdsite;
    }

    public void setProDechetsByIdsite(Collection<ProDechetsEntity> proDechetsByIdsite) {
        this.proDechetsByIdsite = proDechetsByIdsite;
    }

    public Collection<ProPlanificationdelacolletteEntity> getProPlanificationdelacollettesByIdsite() {
        return proPlanificationdelacollettesByIdsite;
    }

    public void setProPlanificationdelacollettesByIdsite(Collection<ProPlanificationdelacolletteEntity> proPlanificationdelacollettesByIdsite) {
        this.proPlanificationdelacollettesByIdsite = proPlanificationdelacollettesByIdsite;
    }

    public ProUtilisateurEntity getProUtilisateurByIdutilisateur() {
        return proUtilisateurByIdutilisateur;
    }

    public void setProUtilisateurByIdutilisateur(ProUtilisateurEntity proUtilisateurByIdutilisateur) {
        this.proUtilisateurByIdutilisateur = proUtilisateurByIdutilisateur;
    }
}
