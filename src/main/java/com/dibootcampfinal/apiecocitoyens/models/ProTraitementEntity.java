package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pro_traitement", schema = "public", catalog = "eco_citoyens")
public class ProTraitementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtraitement", nullable = false)
    private int idtraitement;
    @Basic
    @Column(name = "typedetraitement", nullable = false, length = 45)
    private String typedetraitement;
    @Basic
    @Column(name = "quantitetraitee", nullable = false, length = 45)
    private String quantitetraitee;
    @Basic
    @Column(name = "dateheuretraitement", nullable = false)
    private Timestamp dateheuretraitement;
    @ManyToOne
    @JoinColumn(name = "idcollette", referencedColumnName = "idcollette", nullable = false)
    private ProColletteEntity proColletteByIdcollette;

    public int getIdtraitement() {
        return idtraitement;
    }

    public void setIdtraitement(int idtraitement) {
        this.idtraitement = idtraitement;
    }

    public String getTypedetraitement() {
        return typedetraitement;
    }

    public void setTypedetraitement(String typedetraitement) {
        this.typedetraitement = typedetraitement;
    }

    public String getQuantitetraitee() {
        return quantitetraitee;
    }

    public void setQuantitetraitee(String quantitetraitee) {
        this.quantitetraitee = quantitetraitee;
    }

    public Timestamp getDateheuretraitement() {
        return dateheuretraitement;
    }

    public void setDateheuretraitement(Timestamp dateheuretraitement) {
        this.dateheuretraitement = dateheuretraitement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtraitement, typedetraitement, quantitetraitee, dateheuretraitement);
    }

    public ProColletteEntity getProColletteByIdcollette() {
        return proColletteByIdcollette;
    }

    public void setProColletteByIdcollette(ProColletteEntity proColletteByIdcollette) {
        this.proColletteByIdcollette = proColletteByIdcollette;
    }
}
