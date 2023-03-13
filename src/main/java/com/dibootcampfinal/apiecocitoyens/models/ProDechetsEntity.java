package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pro_dechets", schema = "public", catalog = "eco_citoyens")
public class ProDechetsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddechet", nullable = false)
    private int iddechet;
    @Basic
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "classification", nullable = false, length = 45)
    private String classification;
    @OneToMany(mappedBy = "proDechetsByIddechet")
    private Collection<ProColletteEntity> proCollettesByIddechet;
    @ManyToOne
    @JoinColumn(name = "idsite", referencedColumnName = "idsite", nullable = false)
    private ProSitedecolletteEntity proSitedecolletteByIdsite;

    public int getIddechet() {
        return iddechet;
    }

    public void setIddechet(int iddechet) {
        this.iddechet = iddechet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddechet, nom, description, classification);
    }

    public Collection<ProColletteEntity> getProCollettesByIddechet() {
        return proCollettesByIddechet;
    }

    public void setProCollettesByIddechet(Collection<ProColletteEntity> proCollettesByIddechet) {
        this.proCollettesByIddechet = proCollettesByIddechet;
    }

    public ProSitedecolletteEntity getProSitedecolletteByIdsite() {
        return proSitedecolletteByIdsite;
    }

    public void setProSitedecolletteByIdsite(ProSitedecolletteEntity proSitedecolletteByIdsite) {
        this.proSitedecolletteByIdsite = proSitedecolletteByIdsite;
    }
}
