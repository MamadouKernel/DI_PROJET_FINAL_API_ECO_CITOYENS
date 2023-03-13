package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pro_collette", schema = "public", catalog = "eco_citoyens")
public class ProColletteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcollette", nullable = false)
    private int idcollette;
    @Basic
    @Column(name = "dateheurecollette", nullable = false)
    private Timestamp dateheurecollette;
    @Basic
    @Column(name = "quantitereelle", nullable = false, length = 45)
    private String quantitereelle;

    @ManyToOne
    @JoinColumn(name = "idplanification", referencedColumnName = "idplanification", nullable = false)
    private ProPlanificationdelacolletteEntity proPlanificationdelacolletteByIdplanification;
    @ManyToOne
    @JoinColumn(name = "iddechet", referencedColumnName = "iddechet", nullable = false)
    private ProDechetsEntity proDechetsByIddechet;
    @OneToMany(mappedBy = "proColletteByIdcollette")
    private Collection<ProTraitementEntity> proTraitementsByIdcollette;

    public int getIdcollette() {
        return idcollette;
    }

    public void setIdcollette(int idcollette) {
        this.idcollette = idcollette;
    }

    public Timestamp getDateheurecollette() {
        return dateheurecollette;
    }

    public void setDateheurecollette(Timestamp dateheurecollette) {
        this.dateheurecollette = dateheurecollette;
    }

    public String getQuantitereelle() {
        return quantitereelle;
    }

    public void setQuantitereelle(String quantitereelle) {
        this.quantitereelle = quantitereelle;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProColletteEntity that = (ProColletteEntity) o;
        return idcollette == that.idcollette  && Objects.equals(dateheurecollette, that.dateheurecollette) && Objects.equals(quantitereelle, that.quantitereelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcollette, dateheurecollette, quantitereelle);
    }

    public ProPlanificationdelacolletteEntity getProPlanificationdelacolletteByIdplanification() {
        return proPlanificationdelacolletteByIdplanification;
    }

    public void setProPlanificationdelacolletteByIdplanification(ProPlanificationdelacolletteEntity proPlanificationdelacolletteByIdplanification) {
        this.proPlanificationdelacolletteByIdplanification = proPlanificationdelacolletteByIdplanification;
    }

    public ProDechetsEntity getProDechetsByIddechet() {
        return proDechetsByIddechet;
    }

    public void setProDechetsByIddechet(ProDechetsEntity proDechetsByIddechet) {
        this.proDechetsByIddechet = proDechetsByIddechet;
    }

    public Collection<ProTraitementEntity> getProTraitementsByIdcollette() {
        return proTraitementsByIdcollette;
    }

    public void setProTraitementsByIdcollette(Collection<ProTraitementEntity> proTraitementsByIdcollette) {
        this.proTraitementsByIdcollette = proTraitementsByIdcollette;
    }
}
